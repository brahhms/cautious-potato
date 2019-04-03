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

    @Override
    public AbstractFacade facade() {
        return voteFacade;
    }

    public VoteFacadeTest() {
        super(Vote.class, new Vote(1));

    }

}
