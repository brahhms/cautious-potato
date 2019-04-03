package eis;

import domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author abraham
 */
public class UserFacadeIT {

    EntityManager em;

    UserFacade userFacade;

    public UserFacadeIT() {
        em = Persistence.createEntityManagerFactory("potatoPU-test").createEntityManager();
        this.userFacade = new UserFacade();
    }

    @Before
    public void setUp() {
        Whitebox.setInternalState(userFacade, "em", em);
        userFacade.getEntityManager().getTransaction().begin();
    }

    @Test
    public void testCreate() {
        //verificar estado inicial
        User user = new User();   
        userFacade.create(user);

        List list = userFacade.findAll();
        assertEquals(1, list.size());
        System.out.println(list.get(0).toString());

    }

    @Test
    public void testDelete() {

        User user = new User();
        User user2 = new User(2);

        userFacade.create(user);
        userFacade.create(user2);

        userFacade.remove(user);

        assertEquals(user2, userFacade.find(2));

    }
    
    @Test
    public void testFindUserByEmail(){
        User u = new User();
        userFacade.create(u);
        User result =  userFacade.findUserByEmail(u.getEmail());
        assertEquals(result, u);
    }
    

}
