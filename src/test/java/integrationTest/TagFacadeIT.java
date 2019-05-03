package integrationTest;

import domain.Tag;
import eis.AbstractFacade;
import eis.TagFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class TagFacadeIT extends AbstractTest<Tag> {

    @Inject
    private TagFacade facade;

    public TagFacadeIT() {
        this.NEW = new Tag(3, "html");
        this.EDITED = new Tag(3, "css");
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }

}
