
package eis;

import domain.VoteType;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 * @param <T>
 */
@RunWith(Arquillian.class)

@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
public abstract class AbstractTest<T> {
    
    T entity;
    T entidadEditada;
    T entidadNueva;
    Object idNuevo;
    int numeroRegistros;
    List<T> registros;

    protected abstract AbstractFacade facade();

    protected abstract Object getId();

    protected abstract List<T> getRegistros();

    @Deployment
    public static WebArchive desplegar() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage(VoteTypeFacade.class.getPackage())
                .addPackage(VoteType.class.getPackage())
                .addAsResource("persistence-arq.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(salida.toString(true));
        return salida;
    }
    
    

    @Before
    public void setUp() {
       
        this.registros = getRegistros();
        this.entity = registros.get(0);
        this.entidadNueva = registros.get(1);
        this.entidadEditada = registros.get(2);
        idNuevo = 5;
    }


    @Test
    public void testCreate() {
        try {
            numeroRegistros = facade().count();
        } catch (Exception e) {
            System.err.println(e);
        }
        facade().create(entidadNueva);
        System.out.println("////////////////////////////////////////////////////////");
        System.out.println(facade().find(idNuevo));

    }
/*
    @Test
    public void testDelete() {
        numeroRegistros = cutGeneric.count();
        Assert.assertEquals(2, numeroRegistros);

        cutGeneric.remove(entity);
        numeroRegistros = cutGeneric.count();
        T result = (T) cutGeneric.find(getId());
        Assert.assertNull(result);
        Assert.assertEquals(1, numeroRegistros);
    }



    @Test
    @InSequence(1)
    public void testFind() {
        numeroRegistros = cutGeneric.count();
        Assert.assertEquals(2, numeroRegistros);
        T encontrado = (T) cutGeneric.find(getId());
        Assert.assertTrue(entity.equals(encontrado));
        System.out.println("");
    }

    @Test
    public void testFindAll() {
        encontrados = cutGeneric.findAll();
        Assert.assertEquals(2, encontrados.size());

    }


    @Test
    public void testCount() {
        System.out.println("testCountIT");
        numeroRegistros = cutGeneric.count();
        Assert.assertEquals(2, numeroRegistros);

    }
*/

}
