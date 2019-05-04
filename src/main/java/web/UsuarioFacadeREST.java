package web;

import domain.Usuario;
import eis.AbstractFacade;
import eis.UsuarioFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.usuario")
public class UsuarioFacadeREST extends AbstractREST<Usuario> {

    @Inject
    UsuarioFacade facade;

    @Override
    public AbstractFacade facade() {
        return facade;
    }
}
