package integrationTest;

import domain.TagSynonym;
import eis.AbstractFacade;
import eis.TagFacade;
import eis.TagSynonymFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class TagSynonymFacadeIT extends AbstractTest<TagSynonym> {

    @Inject
    private TagSynonymFacade facade;
    @Inject
    private TagFacade tFacade;

    public TagSynonymFacadeIT() {
        this.NEW = new TagSynonym(3,"Css3");
        this.EDITED = new TagSynonym(3, "js");
    }
    
        @Before
    public void before() {
        NEW.setTagId(tFacade.find(1));
        EDITED.setTagId(tFacade.find(2));
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }

}
