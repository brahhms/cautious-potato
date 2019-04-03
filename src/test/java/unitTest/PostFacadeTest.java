package unitTest;

import domain.Post;
import domain.Tag;
import domain.User;
import eis.PostFacade;
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
public class PostFacadeTest extends AbstractTestFacade<Post> {

    @InjectMocks
    private PostFacade postFacade;

    List<Post> ls;
    Post post;

    public PostFacadeTest() {
        super(Post.class);
        this.post = new Post(1);
        this.buildLs();
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<Post> result = postFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }
    
    

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<Post> result = postFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        postFacade.create(post);
        verify(getEm(), times(1)).persist(post);

    }
    

    @Test
    public void testEdit() {
        postFacade.edit(post);
        verify(getEm(), times(1)).merge(post);

    }

    @Test
    public void testRemove() {
        postFacade.remove(post);
        verify(getEm(), times(1)).remove(getEm().merge(post));

    }

    @Test
    public void testFind() {
        mockFind(post);
        Post result = postFacade.find(post.getId());

        System.out.println(result.toString());
        assertEquals(post, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = postFacade.count();

        assertNotNull(result);
    }
    
    //arreglarlo con patron build
    private void buildLs(){
        this.ls = new ArrayList<>();
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1));
        this.ls.add(post);
        //question
        this.ls.add(new Post(2, "loremipsum", "tomato", "loremipsumtitle2", tags, new User(1)));
        //answer
        this.ls.add(new Post(3,"loremipsum", "cucumber", "loremipsumtitle3", new Post(2), new User(1)));
        //comment
        this.ls.add(new Post("loremipsum", "potato", new Post(3), new User(1)));
    }
    
}
