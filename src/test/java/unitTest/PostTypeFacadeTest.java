package unitTest;

import domain.PostType;
import eis.AbstractFacade;
import eis.PostTypeFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class PostTypeFacadeTest extends AbstractTestFacade<PostType> {

    @InjectMocks
    private PostTypeFacade postTypeFacade;

    @Override
    public AbstractFacade facade() {
        return postTypeFacade;
    }

    public PostTypeFacadeTest() {
        super(PostType.class, new PostType(1));
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

}
