package beans.view;

import domain.VoteType;
import eis.AbstractFacade;
import eis.VoteTypeFacade;
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
public class VoteTypeView extends AbstractView<VoteType> implements Serializable {

    @Inject
    private VoteTypeFacade facade;

    @PostConstruct
    public void init() {
        super.init(new VoteType());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public VoteType getObject() {
        if (this.object== null) {
            this.object = new VoteType();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(VoteType entity) {
        return entity.getId();
    }

    @Override
    protected VoteType getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }

}
