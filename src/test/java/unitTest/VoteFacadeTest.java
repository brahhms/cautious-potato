package unitTest;

import domain.Vote;
import eis.AbstractFacade;
import eis.VoteFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class VoteFacadeTest extends AbstractTestFacade<Vote> {

    @InjectMocks
    private VoteFacade voteFacade;

    public VoteFacadeTest() {
        super(Vote.class, new Vote(1));

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
        return voteFacade;
    }

}
