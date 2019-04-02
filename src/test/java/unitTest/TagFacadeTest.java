package unitTest;

import domain.Tag;
import eis.TagFacade;
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
public class TagFacadeTest extends AbstractTestFacade<Tag> {

    @InjectMocks
    private TagFacade tagFacade;

    List<Tag> ls;
    Tag tag;

    public TagFacadeTest() {
        super(Tag.class);
        this.tag = new Tag(1);
        this.ls = new ArrayList<>();
        this.ls.add(tag);
        this.ls.add(new Tag());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<Tag> result = tagFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<Tag> result = tagFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        tagFacade.create(tag);
        verify(getEm(), times(1)).persist(tag);

    }

    @Test
    public void testEdit() {
        tagFacade.edit(tag);
        verify(getEm(), times(1)).merge(tag);

    }

    @Test
    public void testRemove() {
        tagFacade.remove(tag);
        verify(getEm(), times(1)).remove(getEm().merge(tag));

    }

    @Test
    public void testFind() {
        mockFind(tag);
        Tag result = tagFacade.find(tag.getId());

        System.out.println(result.toString());
        assertEquals(tag, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = tagFacade.count();

        assertNotNull(result);
    }
    
}
