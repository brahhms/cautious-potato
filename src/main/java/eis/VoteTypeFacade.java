package eis;

import domain.VoteType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abraham
 */
@Stateless
public class VoteTypeFacade extends AbstractFacade<VoteType> {

    @PersistenceContext(unitName = "potatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoteTypeFacade() {
        super(VoteType.class);
    }
    
}
