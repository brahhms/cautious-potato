package eis;

import domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class UserFacadeIT {

    public UserFacadeIT() {
    }
    UserFacade userFacade = new UserFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", userFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Before
    public void setUp() {
        facade().getEntityManager().getTransaction().begin();
    }

    @Test
    public void testCreate() {
        System.out.println("testCreate");
        User user = new User();
        facade().create(user);

        List list = facade().findAll();
        assertEquals(1, list.size());
        System.out.println(list.get(0).toString());

    }

    @Test
    public void testDelete() {
        System.out.println("testDelete");
        User user = new User();
        User user2 = new User(2);

        facade().create(user);
        facade().create(user2);
        facade().remove(user);

        assertEquals(user2, facade().find(2));
    }

    @Test
    public void testEdit() {
        System.out.println("testEdit");
        User user = new User(26, "usuario", "correo@gmail.com");

        facade().create(user);
        User user2 = new User(26, "usuarioModificado", "correo@gmail.com");

        facade().edit(user2);
        assertEquals(user.getDisplayName(), user2.getDisplayName());
    }

    @Test
    public void testFindAll() {
        System.out.println("testFindAll");
                
        List<User> ls = new ArrayList<>();
        ls.add(new User(26, "aaa", "abc@correo.com"));
        ls.add(new User(25, "aab", "aab@correo.com"));
        
        for (User u : ls) {
            facade().create(u);
        }
        assertEquals(ls, facade().findAll());
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
