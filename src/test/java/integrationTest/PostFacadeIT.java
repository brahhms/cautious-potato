package integrationTest;

import domain.Post;
import domain.PostType;
import eis.AbstractFacade;
import eis.PostFacade;
import eis.PostTypeFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class PostFacadeIT extends AbstractTest<Post> {

    @Inject
    private PostFacade facade;
    @Inject
    private PostTypeFacade ptFacade;

    public PostFacadeIT() {
        this.NEW = new Post(3, "down", "naruto");
        this.EDITED = new Post(3, "body", "root");
    }

    @Before
    public void before() {
        NEW.setPostTypeId(ptFacade.find(1));
        EDITED.setPostTypeId(ptFacade.find(2));
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }


}
