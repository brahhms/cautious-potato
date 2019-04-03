package unitTest;

import domain.User;
import eis.AbstractFacade;
import eis.UserFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFacadeTest extends AbstractTestFacade<User> {

    @InjectMocks
    private UserFacade userFacade;

    public UserFacadeTest() {
        super(User.class,new User(1));
    }

    @Override
    public void testFindRange() {
        findRange();
    }

    @Override
    public void testFindAll() {
        findAll();
    }

    @Override
    public void testCreate() {
        create();
    }

    @Override
    public void testEdit() {
        edit();
    }

    @Override
    public void testRemove() {
        remove();
    }

    @Override
    public void testFind() {
        find();
    }

    @Override
    public void testCount() {
        count();
    }

    @Override
    public AbstractFacade facade() {
        return userFacade;
    }
    
    
}
