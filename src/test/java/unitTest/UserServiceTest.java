package unitTest;

import beans.model.UserBean;
import domain.User;
import eis.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.Spy;
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

    public UserServiceTest() {
        super(User.class);
        userService = new UserServiceImpl();
    }

    @Before
    public void setUp() {
        userService.setUserFacade(userFacade);
        mockQuery();
    }

    @Test
    public void testGetAllUsers() {
        List<User> expectedLs = new ArrayList<>();
        expectedLs.add(new User(1, "tomato", "tomato@gmail.com"));
        expectedLs.add(new User(1, "cucumber", "cucumber@gmail.com"));
        expectedLs.add(new User(1, "avocado", "avocado@gmail.com"));

        mockResult(expectedLs);
        List<User> result = userService.getAllUsers();

        Assert.assertEquals(expectedLs, result);
    }

    @Test
    public void testCreateUser() {
        UserService serviceSpied = spy(userService);
        doReturn(false).when(serviceSpied).exists(anyString());

        serviceSpied.createUser(new UserBean(1, "brhhms", "http", "@gmail.com"));
        verify(getEm(), times(1)).persist(Matchers.any());
    }

    @Test
    public void testIsActive() {

    }

    @Test
    public void testIncreaseReputation() {

    }

    @Test
    public void testDecreaseReputacion() {

    }

    @Test
    public void testExists() {

    }

    @Test
    public void testExists2() {

    }

    @Test
    public void testDeleteUser() {

    }

    @Test
    public void testUpdateUser() {

    }

}
