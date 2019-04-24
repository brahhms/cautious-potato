package eis;

import domain.VoteType;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class VoteTypeFacadeIT extends AbstractTestFacade<VoteType> {

    private final VoteTypeFacade voteTypeFacade = new VoteTypeFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", voteTypeFacade);

    public VoteTypeFacadeIT() {
        super(VoteType.class, new VoteType());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }
}