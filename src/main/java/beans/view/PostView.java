package beans.view;

import domain.Post;
import domain.PostType;
import domain.Usuario;
import eis.AbstractFacade;
import eis.PostFacade;
import eis.PostTypeFacade;
import eis.UserFacade;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author abraham
 */
@Named
@ViewScoped
public class PostView extends AbstractView<Post> implements Serializable {

    @Inject
    private PostFacade facade;
    @Inject
    private PostTypeFacade postTypeFacade;
    @Inject
    private UserFacade userFacade;
    private final int QUESTION = 1;
    private final int ANSWERS = 2;

    @PostConstruct
    public void init() {
        super.init(new Post());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public Post getObject() {
        if (this.object == null) {
            this.object = new Post();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(Post entity) {
        return entity.getId();
    }

    @Override
    protected Post getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }


    
    public List<PostType> getTypes(){
        return postTypeFacade.findAll();
    }
    public List<Usuario> getUsers(){
        return userFacade.findAll();
    }
    public List<Post> getQuestions(){
        return facade.findPostByType(QUESTION);
    }
    public List<Post> getAnswers(){
        return facade.findPostByType(ANSWERS);
    }
    public void onOwnerChange(){
        this.object.setOwnerDisplayName(this.object.getOwnerUserId().getDisplayName());
    }
    
}
