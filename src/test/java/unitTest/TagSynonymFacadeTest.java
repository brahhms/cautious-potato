package unitTest;

import domain.TagSynonym;
import eis.AbstractFacade;
import eis.TagSynonymFacade;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class TagSynonymFacadeTest extends AbstractTestFacade<TagSynonym> {

    @InjectMocks
    private TagSynonymFacade tagSynonymFacade;

    @Override
    public AbstractFacade facade() {
        return tagSynonymFacade;
    }

    public TagSynonymFacadeTest() {
        super(TagSynonym.class, new TagSynonym(1));
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
