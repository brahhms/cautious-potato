package eis;

import domain.Vote;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class VoteFacadeIT extends AbstractTestFacade<Vote> {

    private final VoteFacade voteFacade = new VoteFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", voteFacade);

    public VoteFacadeIT() {
        super(Vote.class, new Vote());
    }

    @Override
    public AbstractFacade facade() {
        return emp.getFacade();
    }
}