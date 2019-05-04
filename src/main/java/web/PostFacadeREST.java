package web;

import domain.Post;
import eis.AbstractFacade;
import eis.PostFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.post")
public class PostFacadeREST extends AbstractREST<Post>{

    @Inject
    private PostFacade facade;

    @Override
    public AbstractFacade facade() {
        return facade;
    }
    
}
