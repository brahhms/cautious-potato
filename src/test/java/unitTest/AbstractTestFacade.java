package unitTest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
    protected TypedQuery tq;
    @Mock
    private CriteriaBuilder cb;
    @Mock
    private CriteriaQuery cq;

    private final Class<T> entityClass;
    
    public AbstractTestFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public void mockQuery() {
        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery()).thenReturn(cq);
        when(em.createQuery(cq)).thenReturn(tq);
        when(em.createNamedQuery(anyString(),eq(entityClass))).thenReturn(tq);
    }

    public void mockResult(Long value) {
        when(tq.getSingleResult()).thenReturn(value);
    }

    public void mockResult(List<T> ls) {
        when(tq.getResultList()).thenReturn(ls);
    }

    public void mockResult(T entity) {
        when(em.find(eq(entityClass), Mockito.any(Integer.class))).thenReturn(entity);

    }

    
    public EntityManager getEm() {
        return em;
    }

}
