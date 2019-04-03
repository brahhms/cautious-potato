package unitTest;

import domain.VoteType;
import eis.AbstractFacade;
import eis.VoteTypeFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class VoteTypeFacadeTest extends AbstractTestFacade<VoteType> {

    @InjectMocks
    private VoteTypeFacade voteTypeFacade;

    public VoteTypeFacadeTest() {
        super(VoteType.class,new VoteType());
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
        return voteTypeFacade;
    }
    
}
