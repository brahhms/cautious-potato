
package eis;

import domain.Comment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abraham
 */
@Stateless
public class CommentFacade extends AbstractFacade<Comment> implements CommentFacadeLocal {

    @PersistenceContext(unitName = "sv.com.tpi_CautiousPotato_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }
    
}
