package eis;

import domain.User;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author abraham
 */
public class UserFacadeIT extends AbstractTestFacade<User> {

    private final UserFacade userFacade = new UserFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", userFacade);
      
    public UserFacadeIT() {
        super(User.class, new User());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testFindUserByEmail() {
        User u = new User();
        u.setEmail("abc@correo.com");
        userFacade.create(u);
        User result = userFacade.findUserByEmail(u.getEmail());
        assertEquals(result, u);
    }
     
}