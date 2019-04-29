package eis;

import domain.PostType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author abraham
 */
public class PostTypeFacadeIT {

    private final PostTypeFacade postTypeFacade;
    private final EntityManager em;

    public PostTypeFacadeIT() {
        em = Persistence.createEntityManagerFactory("potatoPU-test").createEntityManager();
        this.postTypeFacade = new PostTypeFacade();
    }

    @Before
    public void setUp() {
        Whitebox.setInternalState(postTypeFacade, "em", em);
        postTypeFacade.getEntityManager().getTransaction().begin();
    }

    @Test
    public void testFindRange() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("test findRange -----------------------------------");

        for (int i = 0; i < 5; i++) {
            postTypeFacade.create(new PostType(i+10, "postType"));
        }
        List<PostType> ls = postTypeFacade.findRange(new int[]{1, 2});
        System.out.println(ls);
        Assert.assertNotNull(ls);
    }

}
