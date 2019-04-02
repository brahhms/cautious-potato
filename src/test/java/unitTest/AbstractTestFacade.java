package unitTest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.mockito.Matchers;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 *
 * @author abraham
 * @param <T>
 */
public abstract class AbstractTestFacade<T> {

    @Mock
    private EntityManager em;
    @Mock
    private CriteriaBuilder cb;
    @Mock
    private CriteriaQuery cq;
    @Mock
    private Root<T> root;
    @Mock
    private CriteriaQuery cqAll;
    @Mock
    protected TypedQuery tq;

    private final Class<T> entityClass;

    public AbstractTestFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void mockResult(Long value) {
        when(tq.getSingleResult()).thenReturn(value);
    }

    public void mockResult(List<T> ls) {
        when(tq.getResultList()).thenReturn(ls);
    }

    public void mockResult(T entity) {
        when(tq.getSingleResult()).thenReturn(entity);

    }

    public void mockFind(T entity) {
        when(em.find(eq(entityClass), Mockito.any(Integer.class))).thenReturn(entity);
    }
    
  
    public EntityManager getEm() {
        return em;
    }

    public void mockQuery() {
        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery()).thenReturn(cq);

        when(cq.from(entityClass)).thenReturn(root);
        when(cq.select(root)).thenReturn(cqAll);
        
        when(em.createQuery(cq)).thenReturn(tq);

        //when(em.createNamedQuery(anyString(), eq(entityClass))).thenReturn(tq);
    }

}
