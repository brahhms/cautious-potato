package integrationTest;

import domain.Usuario;
import eis.AbstractFacade;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 * @param <T>
 */
@RunWith(Arquillian.class)
@UsingDataSet("datasets/dataIT.json")
@Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.USED_TABLES_ONLY)
public abstract class AbstractTest<T> {

    private int recordsCount = 0;
    T NEW,EDITED;

    @Deployment
    public static WebArchive desplegar() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage(AbstractFacade.class.getPackage())
                .addPackage(Usuario.class.getPackage())
                .addAsResource("persistence-arq.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(salida.toString(true));
        return salida;
    }



    @Test
    @InSequence(1)
    public void testCount() {
        System.out.println("///////testCount ////////");

        recordsCount = facade().count();
        Assert.assertEquals(2, recordsCount);
    }

    @Test
    @InSequence(2)
    public void testCreate() {
        System.out.println("///////testCreate////////");

        facade().create(NEW);
        Assert.assertTrue(facade().count() > recordsCount);
    }

    @Test
    @InSequence(3)
    public void testFind() {
        System.out.println("///////testFind  ////////");
        Assert.assertEquals(NEW, facade().find(3));
    }

    @Test
    @InSequence(4)
    public void testFindAll() {
        System.out.println("///////testFindAll///////");

        recordsCount = facade().count();
        List<T> actual = facade().findAll();

        Assert.assertEquals(recordsCount, actual.size());
    }

    @Test
    @InSequence(5)
    public void testFindRange() {
        System.out.println("///////testFindRange/////");

        List<T> actual = facade().findRange(new int[]{0, 1});
        Assert.assertEquals(2, actual.size());
    }

    @Test
    @InSequence(6)
    public void testEdit() {
        System.out.println("///////testEdit  ////////");

        T actual = (T) facade().find(3);
        facade().edit(EDITED);

        Assert.assertNotSame(EDITED, actual);
    }

    @Test
    @InSequence(7)
    public void testDelete() {
        System.out.println("///////testDelete////////");

        Assert.assertNotNull(facade().find(3));
        facade().remove(EDITED);
        Assert.assertNull(facade().find(3));
    }

    protected abstract AbstractFacade facade();

}
