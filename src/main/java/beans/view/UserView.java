package beans.view;

import domain.User;
import eis.AbstractFacade;
import eis.UserFacade;
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
public class UserView extends AbstractView<User> implements Serializable {

    @Inject
    private UserFacade facade;

    @PostConstruct
    public void init() {
        super.init(new User());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public User getObject() {
        if (this.object== null) {
            this.object = new User();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(User entity) {
        return entity.getId();
    }

    @Override
    protected User getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }
 
    
}
