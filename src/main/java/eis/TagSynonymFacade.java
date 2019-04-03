package eis;

import domain.TagSynonym;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abraham
 */
@Stateless
public class TagSynonymFacade extends AbstractFacade<TagSynonym> {

    @PersistenceContext(unitName = "potatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TagSynonymFacade() {
        super(TagSynonym.class);
    }
    
}
