package beans.view;

import domain.PostType;
import eis.AbstractFacade;
import eis.PostTypeFacade;
import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author abraham
 */
@Named
@ViewScoped
public class PostTypeView extends AbstractView<PostType> implements Serializable {

    @Inject
    private PostTypeFacade facade;

    @PostConstruct
    public void init() {
        super.init(new PostType());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public PostType getObject() {
        if (this.object == null) {
            this.object = new PostType();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(PostType entity) {
        return entity.getId();
    }

    @Override
    protected PostType getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }

    public void setLazyModel(LazyDataModel<PostType> lazyModel) {
        this.lazyModel = lazyModel;
    }

}
