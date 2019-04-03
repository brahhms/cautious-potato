package unitTest;

import domain.Tag;
import eis.AbstractFacade;
import eis.TagFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class TagFacadeTest extends AbstractTestFacade<Tag> {

    @InjectMocks
    private TagFacade tagFacade;

    @Override
    public AbstractFacade facade() {
        return tagFacade;
    }

    public TagFacadeTest() {
        super(Tag.class, new Tag());
    }

    @Override
    public void testFindRange() {
        findRange();
    }

    @Override
    public void testFindAll() {
        findAll();
    }

    @Override
    public void testCreate() {
        create();
    }

    @Override
    public void testEdit() {
        edit();
    }

    @Override
    public void testRemove() {
        remove();
    }

    @Override
    public void testFind() {
        find();
    }

    @Override
    public void testCount() {
        count();
    }

}
