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

    @Override
    public AbstractFacade facade() {
        return voteTypeFacade;
    }

    public VoteTypeFacadeTest() {
        super(VoteType.class, new VoteType());
    }

}
