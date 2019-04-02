package unitTest;

import domain.Vote;
import eis.VoteFacade;
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
public class VoteFacadeTest extends AbstractTestFacade<Vote> {

    @InjectMocks
    private VoteFacade voteFacade;

    List<Vote> ls;
    Vote vote;

    public VoteFacadeTest() {
        super(Vote.class);
        this.vote = new Vote(1);
        this.ls = new ArrayList<>();
        this.ls.add(vote);
        this.ls.add(new Vote());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<Vote> result = voteFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<Vote> result = voteFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        voteFacade.create(vote);
        verify(getEm(), times(1)).persist(vote);

    }

    @Test
    public void testEdit() {
        voteFacade.edit(vote);
        verify(getEm(), times(1)).merge(vote);

    }

    @Test
    public void testRemove() {
        voteFacade.remove(vote);
        verify(getEm(), times(1)).remove(getEm().merge(vote));

    }

    @Test
    public void testFind() {
        mockFind(vote);
        Vote result = voteFacade.find(vote.getId());

        System.out.println(result.toString());
        assertEquals(vote, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = voteFacade.count();

        assertNotNull(result);
    }
    
}
