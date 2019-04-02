package unitTest;

import domain.TagSynonym;
import eis.TagSynonymFacade;
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
public class TagSynonymFacadeTest extends AbstractTestFacade<TagSynonym> {

    @InjectMocks
    private TagSynonymFacade tagSynonymFacade;

    List<TagSynonym> ls;
    TagSynonym tagSynonym;

    public TagSynonymFacadeTest() {
        super(TagSynonym.class);
        this.tagSynonym = new TagSynonym(1);
        this.ls = new ArrayList<>();
        this.ls.add(tagSynonym);
        this.ls.add(new TagSynonym());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<TagSynonym> result = tagSynonymFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<TagSynonym> result = tagSynonymFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        tagSynonymFacade.create(tagSynonym);
        verify(getEm(), times(1)).persist(tagSynonym);

    }

    @Test
    public void testEdit() {
        tagSynonymFacade.edit(tagSynonym);
        verify(getEm(), times(1)).merge(tagSynonym);

    }

    @Test
    public void testRemove() {
        tagSynonymFacade.remove(tagSynonym);
        verify(getEm(), times(1)).remove(getEm().merge(tagSynonym));

    }

    @Test
    public void testFind() {
        mockFind(tagSynonym);
        TagSynonym result = tagSynonymFacade.find(tagSynonym.getId());

        System.out.println(result.toString());
        assertEquals(tagSynonym, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = tagSynonymFacade.count();

        assertNotNull(result);
    }
    
}
