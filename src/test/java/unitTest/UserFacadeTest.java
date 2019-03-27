package unitTest;

import domain.User;
import eis.UserFacade;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTest extends AbstractTestFacade<User> {

    @InjectMocks
    private UserFacade userFacade;

    List<User> ls;
    User user;

    public UserFacadeTest() {
        super(User.class);
        this.user = new User(1);
        this.ls = new ArrayList<>();
        this.ls.add(user);
        this.ls.add(new User());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<User> result = userFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<User> result = userFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        userFacade.create(user);
        verify(getEm(), times(1)).persist(user);

    }

    @Test
    public void testEdit() {
        userFacade.edit(user);
        verify(getEm(), times(1)).merge(user);

    }

    @Test
    public void testRemove() {
        userFacade.remove(user);
        verify(getEm(), times(1)).remove(getEm().merge(user));

    }

    @Test
    public void testFind() {
        mockResult(user);
        User result = userFacade.find(user.getId());

        System.out.println(result.toString());
        assertEquals(user, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = userFacade.count();

        assertNotNull(result);
    }
    
}
