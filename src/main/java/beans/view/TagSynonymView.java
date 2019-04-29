package beans.view;

import domain.Tag;
import domain.TagSynonym;
import eis.AbstractFacade;
import eis.TagFacade;
import eis.TagSynonymFacade;
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
public class TagSynonymView extends AbstractView<TagSynonym> implements Serializable {

    @Inject
    private TagSynonymFacade facade;

    @Inject
    private TagFacade tagFacade;
    private List<Tag> tags;

    @PostConstruct
    public void init() {
        super.init(new TagSynonym());
        tags = tagFacade.findAll();
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public TagSynonym getObject() {
        if (this.object == null) {
            this.object = new TagSynonym();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(TagSynonym entity) {
        return entity.getId();
    }

    @Override
    protected TagSynonym getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }

    public List<Tag> getTags() {
        return tagFacade.findAll();
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    


}
