package unitTest;

import domain.VoteType;
import eis.VoteTypeFacade;
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
public class VoteTypeFacadeTest extends AbstractTestFacade<VoteType> {

    @InjectMocks
    private VoteTypeFacade voteTypeFacade;

    List<VoteType> ls;
    VoteType voteType;

    public VoteTypeFacadeTest() {
        super(VoteType.class);
        this.voteType = new VoteType(1);
        this.ls = new ArrayList<>();
        this.ls.add(voteType);
        this.ls.add(new VoteType());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<VoteType> result = voteTypeFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<VoteType> result = voteTypeFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        voteTypeFacade.create(voteType);
        verify(getEm(), times(1)).persist(voteType);

    }

    @Test
    public void testEdit() {
        voteTypeFacade.edit(voteType);
        verify(getEm(), times(1)).merge(voteType);

    }

    @Test
    public void testRemove() {
        voteTypeFacade.remove(voteType);
        verify(getEm(), times(1)).remove(getEm().merge(voteType));

    }

    @Test
    public void testFind() {
        mockResult(voteType);
        VoteType result = voteTypeFacade.find(voteType.getId());

        System.out.println(result.toString());
        assertEquals(voteType, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = voteTypeFacade.count();

        assertNotNull(result);
    }
    
}
