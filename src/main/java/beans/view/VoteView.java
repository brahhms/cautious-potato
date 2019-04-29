package beans.view;

import domain.Vote;
import eis.AbstractFacade;
import eis.PostFacade;
import eis.UserFacade;
import eis.VoteFacade;
import eis.VoteTypeFacade;
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
public class VoteView extends AbstractView<Vote> implements Serializable {

    @Inject
    private VoteFacade facade;
    @Inject
    private PostFacade postFacade;
    @Inject
    private UserFacade userFacade;
    @Inject
    private VoteTypeFacade voteTypeFacade;

    @PostConstruct
    public void init() {
        super.init(new Vote());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public Vote getObject() {
        if (this.object== null) {
            this.object = new Vote();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(Vote entity) {
        return entity.getId();
    }

    @Override
    protected Vote getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }
 
    public List getPosts(){
        return postFacade.findAll();
    }
    public List getUsers(){
        return userFacade.findAll();
    }
    public List getVoteTypes(){
        return voteTypeFacade.findAll();
    }
    
    
}
