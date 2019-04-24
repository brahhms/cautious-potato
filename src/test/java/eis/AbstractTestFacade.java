package eis;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author abraham
 * @param <T>
 */
public abstract class AbstractTestFacade<T> {


    private final Class<T> entityClass;
    T entity;

    public AbstractTestFacade(Class<T> entityClass, T entity) {
        this.entityClass = entityClass;
        this.entity = entity;
    }

    @Before
    public void setUp() {
        facade().getEntityManager().getTransaction().begin();
    }

    @Test
    public void testCreate() {
        facade().create(entity);

        List list = facade().findAll();
        assertEquals(1, list.size());

    }

    @Test
    public void testDelete() throws InstantiationException, IllegalAccessException {
        T entity2 = entityClass.newInstance();

        facade().create(entity);
        facade().create(entity2);
        facade().remove(entity);

        assertEquals(1, facade().count());
    }

    @Test
    public void testEdit() throws InstantiationException, IllegalAccessException {
        T entity2 = entity;

        facade().create(entity2);

        facade().edit(entity);
        assertEquals(facade().find(entity2), entity);
    }

    @Test
    public void testFindAll() {

        List<T> ls = new ArrayList<>();
        ls.add(entity);
        ls.add(entity);

        for (T t : ls) {
           facade().create(entity);
        }
        assertEquals(ls, facade().findAll());
    }

    ///////////////////////////////////////////////////////////////////
    public abstract AbstractFacade facade();

}
