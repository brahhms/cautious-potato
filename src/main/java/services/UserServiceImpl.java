package services;

import domain.User;
import eis.UserFacadeLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author abraham
 */
@Stateless
public class UserServiceImpl implements UserService {

    //@Resource
    //private SessionContext contexto;

    @Inject
    private UserFacadeLocal userFacade;

    @Override
    public List<User> getAllUsers() {
        try {
            return userFacade.findAll();
        } catch (Throwable t) {
            //contexto.setRollbackOnly();
            t.printStackTrace(System.out);
            return null;
        }

    }
}
