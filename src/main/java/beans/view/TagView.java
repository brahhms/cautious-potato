package beans.view;

import domain.Tag;
import eis.AbstractFacade;
import eis.TagFacade;
import java.io.Serializable;
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
public class TagView extends AbstractView<Tag> implements Serializable {

    @Inject
    private TagFacade facade;

    @PostConstruct
    public void init() {
        super.init(new Tag());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public Tag getObject() {
        if (this.object== null) {
            this.object = new Tag();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(Tag entity) {
        return entity.getId();
    }

    @Override
    protected Tag getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }
 
    
}
