package unitTest;

import domain.Post;
import eis.AbstractFacade;
import eis.PostFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class PostFacadeTest extends AbstractTestFacade<Post> {

    @InjectMocks
    private PostFacade postFacade;

    @Override
    public AbstractFacade facade() {
        return postFacade;
    }

    public PostFacadeTest() {
        super(Post.class, new Post());
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
