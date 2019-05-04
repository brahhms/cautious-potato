
package web;

import domain.PostType;
import eis.AbstractFacade;
import eis.PostTypeFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.posttype")
public class PostTypeFacadeREST extends AbstractREST<PostType> {

    @Inject
    PostTypeFacade facade;
    
    @Override
    public AbstractFacade facade() {
        return facade;
    }
}
