package eis;

import domain.Post;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class PostFacadeIT extends AbstractTestFacade<Post> {

    private final PostFacade postFacade = new PostFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", postFacade);
      
    public PostFacadeIT() {
        super(Post.class, new Post());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }
}