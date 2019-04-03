package unitTest;

import eis.AbstractFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.eq;

import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    List<T> ls;
    T entity;

    public AbstractTestFacade(Class<T> entityClass, T entity) {
        this.entityClass = entityClass;
        this.entity = entity;
        this.ls = new ArrayList();
        ls.add(entity);
    }

    public void mockQuery() {
        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery()).thenReturn(cq);
        when(cq.from(entityClass)).thenReturn(root);
        when(cq.select(root)).thenReturn(cqAll);
        when(em.createQuery(cq)).thenReturn(tq);
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void findRange() {
        mockResult(ls);
        List<T> result = facade().findRange(new int[2]);
        assertEquals(ls, result);
    }

    public void findAll() {
        mockResult(ls);
        List<T> result = facade().findAll();
        assertNotNull(result);
        assertEquals(ls, result);
    }

    public void create() {
        facade().create(entity);
        verify(em, times(1)).persist(entity);
    }

    public void edit() {
        facade().edit(entity);
        verify(em, times(1)).merge(entity);
    }

    public void remove() {
        facade().remove(entity);
        verify(em, times(1)).remove(em.merge(entity));
    }

    public void find() {
        when(em.find(eq(entityClass), Mockito.any(Integer.class))).thenReturn(entity);
        T result = (T) facade().find(1);
        System.out.println(result.toString());
        assertEquals(entity, result);
    }

    public void count() {
        mockResult(5L);
        int result = facade().count();
        assertNotNull(result);
    }

    ///////////////////////////////////////////////////////////////////
    public abstract AbstractFacade facade();

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public abstract void testFindRange();

    @Test
    public abstract void testFindAll();

    @Test
    public abstract void testCreate();

    @Test
    public abstract void testEdit();

    @Test
    public abstract void testRemove();

    @Test
    public abstract void testFind();

    @Test
    public abstract void testCount();

}
