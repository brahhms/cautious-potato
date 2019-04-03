package eis;

import domain.PostType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abraham
 */
@Stateless
public class PostTypeFacade extends AbstractFacade<PostType>  {

    @PersistenceContext(unitName = "potatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostTypeFacade() {
        super(PostType.class);
    }
    
}
