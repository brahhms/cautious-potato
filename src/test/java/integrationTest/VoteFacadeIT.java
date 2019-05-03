package integrationTest;

import domain.Vote;
import eis.AbstractFacade;
import eis.PostFacade;
import eis.UsuarioFacade;
import eis.VoteFacade;
import eis.VoteTypeFacade;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class VoteFacadeIT extends AbstractTest<Vote> {

    @Inject
    private VoteFacade facade;
    @Inject
    private PostFacade posts;
    @Inject
    private UsuarioFacade users;
    @Inject
    private VoteTypeFacade vTypes;

    public VoteFacadeIT() {
        this.NEW = new Vote(3);
        this.EDITED = new Vote(3);
    }

    @Before
    public void before() {
        NEW.setPostId(posts.find(1));
        NEW.setUserId(users.find(1));
        NEW.setVoteTypeId(vTypes.find(1));
        NEW.setPostId(posts.find(2));
        NEW.setUserId(users.find(2));
        NEW.setVoteTypeId(vTypes.find(2));
    }

    @Override
    protected AbstractFacade facade() {
        return facade;
    }

}
