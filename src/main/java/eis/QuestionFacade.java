
package eis;

import domain.Question;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abraham
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> implements QuestionFacadeLocal {

    @PersistenceContext(unitName = "sv.com.tpi_CautiousPotato_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }
    
}
