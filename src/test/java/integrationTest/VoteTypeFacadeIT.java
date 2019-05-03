package integrationTest;

import domain.VoteType;
import eis.AbstractFacade;
import eis.VoteTypeFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class VoteTypeFacadeIT extends AbstractTest<VoteType> {

    @Inject
    private VoteTypeFacade facade;

    public VoteTypeFacadeIT() {
        this.EDITED = new VoteType(3, "up");
        this.NEW = new VoteType(3, "down");
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }

}
