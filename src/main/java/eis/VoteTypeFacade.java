
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
public class VoteTypeFacade extends AbstractFacade<VoteType> implements VoteTypeFacadeLocal {

    @PersistenceContext(unitName = "sv.com.tpi_CautiousPotato_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoteTypeFacade() {
        super(VoteType.class);
    }
    
}
