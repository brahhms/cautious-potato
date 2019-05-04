
package web;

import domain.TagSynonym;
import eis.AbstractFacade;
import eis.TagSynonymFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.tagsynonym")
public class TagSynonymFacadeREST extends AbstractREST<TagSynonym> {
     
    @Inject
    TagSynonymFacade facade;
    
    @Override
    public AbstractFacade facade() {
        return facade;
    }
    
}
