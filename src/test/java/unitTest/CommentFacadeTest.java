package unitTest;

import domain.Comment;
import eis.CommentFacade;
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
public class CommentFacadeTest extends AbstractTestFacade<Comment> {

    @InjectMocks
    private CommentFacade commentFacade;

    List<Comment> ls;
    Comment comment;

    public CommentFacadeTest() {
        super(Comment.class);
        this.comment = new Comment(1);
        this.ls = new ArrayList<>();
        this.ls.add(comment);
        this.ls.add(new Comment());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<Comment> result = commentFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<Comment> result = commentFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        commentFacade.create(comment);
        verify(getEm(), times(1)).persist(comment);

    }

    @Test
    public void testEdit() {
        commentFacade.edit(comment);
        verify(getEm(), times(1)).merge(comment);

    }

    @Test
    public void testRemove() {
        commentFacade.remove(comment);
        verify(getEm(), times(1)).remove(getEm().merge(comment));

    }

    @Test
    public void testFind() {
        mockResult(comment);
        Comment result = commentFacade.find(comment.getId());

        System.out.println(result.toString());
        assertEquals(comment, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = commentFacade.count();

        assertNotNull(result);
    }
    
}
