package unitTest;

import domain.TagSynonym;
import eis.AbstractFacade;
import eis.TagSynonymFacade;
import org.junit.Ignore;
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


}
