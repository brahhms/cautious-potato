package web;

import domain.Vote;
import eis.AbstractFacade;
import eis.VoteFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.vote")
public class VoteFacadeREST extends AbstractREST<Vote> {

    @Inject
    VoteFacade facade;

    @Override
    public AbstractFacade facade() {
        return facade;
    }
}
