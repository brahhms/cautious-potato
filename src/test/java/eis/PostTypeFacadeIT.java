package eis;

import domain.PostType;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class PostTypeFacadeIT extends AbstractTestFacade<PostType> {

    private final PostTypeFacade postTypeFacade = new PostTypeFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", postTypeFacade);

    public PostTypeFacadeIT() {
        super(PostType.class, new PostType());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }
}
