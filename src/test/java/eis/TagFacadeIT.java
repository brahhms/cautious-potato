package eis;

import domain.Tag;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class TagFacadeIT extends AbstractTestFacade<Tag> {

    private final TagFacade tagFacade = new TagFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", tagFacade);

    public TagFacadeIT() {
        super(Tag.class, new Tag());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }
}