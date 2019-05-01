package eis;

import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class UserFacadeIT extends AbstractTest<Usuario> {

    @Inject
    private UserFacade cut;
    List<Usuario> datos = new ArrayList<>();

    public UserFacadeIT() {
        datos.add(new Usuario(1, "displayName", "email") );
        datos.add(new Usuario(5, "displayUserName", "e-mail") );
        datos.add(new Usuario(1, "displayName", "email"));
        this.idNuevo = 5;
    }

    @Override
    protected AbstractFacade facade() {
        return cut;
    }

    @Override
    protected List<Usuario> getRegistros() {
        return datos;

    }

    @Override
    protected Object getId() {
        return entity.getId();
    }

}
