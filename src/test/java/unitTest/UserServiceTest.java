package unitTest;

import beans.model.UserBean;
import domain.User;
import eis.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import services.UserService;
import services.UserServiceImpl;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends AbstractTestFacade<User> {

    @InjectMocks
    private UserFacade userFacade;
    @Inject
    UserService userService;
    private final User user;

    public UserServiceTest() {
        super(User.class);
        userService = new UserServiceImpl();
        user = new User(1);
    }

    @Before
    public void setUp() {
        userService.setUserFacade(userFacade);
        mockQuery();
    }

    @Test
    public void testGetAllUsers() {
        List<User> expectedLs = new ArrayList<>();
        expectedLs.add(new User(2, "tomato", "tomato@gmail.com"));
        expectedLs.add(new User(3, "cucumber", "cucumber@gmail.com"));
        expectedLs.add(new User(4, "avocado", "avocado@gmail.com"));

        mockResult(expectedLs);
        List<User> result = userService.getAllUsers();

        assertEquals(expectedLs, result);
    }

    @Test
    public void testCreateValidUser() {
        UserService serviceSpied = spy(userService);
        doReturn(false).when(serviceSpied).exists(anyString());

        serviceSpied.createUser(new UserBean(1, "brhhms", "http", "@gmail.com"));
        verify(getEm(), times(1)).persist(Matchers.any());
    }

    @Test
    public void testIsActive() {
        user.setStatus(1);
        mockFind(user);
        boolean result = userService.isActive(user.getId());
        assertEquals(true, result);
    }

    @Test
    public void testIncreaseReputation() {
        user.setReputation(0);
        mockFind(user);
        userService.increaseReputation(user.getId(), 15);
        verify(getEm(), times(1)).merge(user);
    }

    @Test
    public void testDecreaseReputacion() {
        user.setReputation(15);
        mockFind(user);
        userService.decreaseReputacion(user.getId(), 15);
        verify(getEm(), times(1)).merge(user);
    }

    @Test
    public void testExistsEmail() {
        user.setEmail("abrakadabra@gmail.com");
        mockResult(user);
        boolean result = userService.exists(user.getEmail());
        assertNotNull(result);
        assertEquals(true, result);
    }

    @Test
    public void testExistsId() {
        mockResult(user);
        boolean result = userService.exists(user.getId());
        assertNotNull(result);
        assertEquals(true, result);
    }

    @Test
    public void testDeleteUser() {
        mockFind(user);
        userService.deleteUser(user.getId());
        verify(getEm(), times(1)).merge(user);

    }

    @Test
    public void testUpdateUser() {
        mockFind(user);
        userService.updateUser(new UserBean(1, "tomato", "http://", "tomato@gamil.com"));
        verify(getEm(), times(1)).merge(user);
    }

}
