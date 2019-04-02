package unitTest;

import domain.PostType;
import eis.PostTypeFacade;
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
public class PostTypeFacadeTest extends AbstractTestFacade<PostType> {

    @InjectMocks
    private PostTypeFacade postTypeFacade;

    List<PostType> ls;
    PostType postType;

    public PostTypeFacadeTest() {
        super(PostType.class);
        this.postType = new PostType(1);
        this.ls = new ArrayList<>();
        this.ls.add(postType);
        this.ls.add(new PostType());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<PostType> result = postTypeFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<PostType> result = postTypeFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        postTypeFacade.create(postType);
        verify(getEm(), times(1)).persist(postType);

    }

    @Test
    public void testEdit() {
        postTypeFacade.edit(postType);
        verify(getEm(), times(1)).merge(postType);

    }

    @Test
    public void testRemove() {
        postTypeFacade.remove(postType);
        verify(getEm(), times(1)).remove(getEm().merge(postType));

    }

    @Test
    public void testFind() {
        mockFind(postType);
        PostType result = postTypeFacade.find(postType.getId());

        System.out.println(result.toString());
        assertEquals(postType, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = postTypeFacade.count();

        assertNotNull(result);
    }
    
}
