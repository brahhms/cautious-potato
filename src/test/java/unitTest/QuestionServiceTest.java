package unitTest;

import domain.Post;
import eis.PostFacade;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import services.QuestionService;
import services.QuestionServiceImpl;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest extends AbstractTestFacade<Post> {

    @InjectMocks
    private PostFacade postFacade;
    @Inject
    QuestionService questionService;

    public QuestionServiceTest() {
        super(Post.class);
        questionService = new QuestionServiceImpl();
    }

    @Before
    public void setUp() {
        questionService.setPostFacade(postFacade);
        mockQuery();
    }

    @Test
    public void testCreateQuestion() {

    }

}
