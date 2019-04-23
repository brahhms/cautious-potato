package eis;

import domain.PostType;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author abraham
 */
public class PostTypeFacadeIT {

    public PostTypeFacadeIT() {
    }
    PostTypeFacade postTypeFacade = new PostTypeFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", postTypeFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Before
    public void setUp() {
        facade().getEntityManager().getTransaction().begin();
    }

    @Test
    public void testCreate() {
        System.out.println("testCreate");
        PostType type = new PostType();
        facade().create(type);

        List list = facade().findAll();
        assertEquals(1, list.size());

    }

    @Test
    public void testDelete() {
        System.out.println("testDelete");
        PostType type = new PostType();
        PostType type2 = new PostType(2);

        facade().create(type);
        facade().create(type2);
        facade().remove(type);

        assertEquals(type2, facade().find(2));
    }

    @Test
    public void testEdit() {
        System.out.println("testEdit");
        PostType type = new PostType(26, "question");

        facade().create(type);
        PostType type2 = new PostType(26, "answer");

        facade().edit(type2);
        assertEquals(type.getName(), type2.getName());
    }

    @Test
    public void testFindAll() {
        System.out.println("testFindAll");
                
        List<PostType> ls = new ArrayList<>();
        ls.add(new PostType(26, "aaa"));
        ls.add(new PostType(25, "aab"));
        
        for (PostType p : ls) {
            facade().create(p);
        }
        assertEquals(ls, facade().findAll());
    }


}
