package web;

import domain.Tag;
import eis.AbstractFacade;
import eis.TagFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.tag")
public class TagFacadeREST extends AbstractREST<Tag> {

    @Inject
    TagFacade facade;

    @Override
    public AbstractFacade facade() {
        return facade;
    }

}
