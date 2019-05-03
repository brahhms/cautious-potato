package beans.view;

import domain.Usuario;
import eis.AbstractFacade;
import eis.UsuarioFacade;
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
public class UserView extends AbstractView<Usuario> implements Serializable {

    @Inject
    private UsuarioFacade facade;

    @PostConstruct
    public void init() {
        super.init(new Usuario());
    }

    @Override
    public AbstractFacade facade() {
        return facade;
    }

    @Override
    public Usuario getObject() {
        if (this.object== null) {
            this.object = new Usuario();
        }
        return this.object;
    }

    @Override
    protected Object rowKey(Usuario entity) {
        return entity.getId();
    }

    @Override
    protected Usuario getRData(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            return this.getLazyModel().getWrappedData().stream().
                    filter(tp -> tp.getId().toString().compareTo(rowKey) == 0).collect(Collectors.toList()).get(0);
        }
        return null;
    }
 
    
}
