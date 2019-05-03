package unitTest;

import domain.Usuario;
import eis.AbstractFacade;
import eis.UsuarioFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTest extends AbstractTestFacade<Usuario> {

    @InjectMocks
    private UsuarioFacade userFacade;

    @Override
    public AbstractFacade facade() {
        return userFacade;
    }

    public UserFacadeTest() {
        super(Usuario.class, new Usuario(1));
    }

}
