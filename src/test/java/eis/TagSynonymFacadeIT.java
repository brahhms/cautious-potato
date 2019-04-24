package eis;

import domain.TagSynonym;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class TagSynonymFacadeIT extends AbstractTestFacade<TagSynonym> {

    private final TagSynonymFacade tagSynonymFacade = new TagSynonymFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", tagSynonymFacade);

    public TagSynonymFacadeIT() {
        super(TagSynonym.class, new TagSynonym());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }
}