
package eis;

import domain.Vote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abraham
 */
@Stateless
public class VoteFacade extends AbstractFacade<Vote> implements VoteFacadeLocal {

    @PersistenceContext(unitName = "sv.com.tpi_CautiousPotato_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoteFacade() {
        super(Vote.class);
    }
    
}
