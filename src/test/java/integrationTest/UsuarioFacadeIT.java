package integrationTest;

import domain.Usuario;
import eis.AbstractFacade;
import eis.UsuarioFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class UsuarioFacadeIT extends AbstractTest<Usuario> {

    @Inject
    private UsuarioFacade facade;

    public UsuarioFacadeIT() {
        this.EDITED = new Usuario(3, "displayName", "email@gmail.com");
        this.NEW = new Usuario(3, "displayName","e-mail@yahoo.es");
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }
    
}
