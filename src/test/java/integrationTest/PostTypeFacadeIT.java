package integrationTest;

import domain.PostType;
import eis.AbstractFacade;
import eis.PostTypeFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class PostTypeFacadeIT extends AbstractTest<PostType> {

    @Inject
    private PostTypeFacade facade;

    public PostTypeFacadeIT() {
        this.NEW = new PostType(3, "question");
        this.EDITED = new PostType(3, "answer");
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }


}
