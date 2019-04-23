package eis;

import domain.User;
import domain.VoteType;
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
public class VoteTypeFacadeIT {

    public VoteTypeFacadeIT() {
    }
    VoteTypeFacade voteTypeFacade = new VoteTypeFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("potatoPU-test", voteTypeFacade);

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
        VoteType type = new VoteType();
        facade().create(type);

        List list = facade().findAll();
        assertEquals(1, list.size());
        System.out.println(list.get(0).toString());

    }

    @Test
    public void testDelete() {
        System.out.println("testDelete");
        VoteType type = new VoteType();
        VoteType type2 = new VoteType(2);

        facade().create(type);
        facade().create(type2);
        facade().remove(type);

        assertEquals(type2, facade().find(2));
    }

    @Test
    public void testEdit() {
        System.out.println("testEdit");
        VoteType type = new VoteType(26, "favorite");

        facade().create(type);
        VoteType type2 = new VoteType(26, "up");

        facade().edit(type2);
        assertEquals(type.getName(), type2.getName());
    }

    @Test
    public void testFindAll() {
        System.out.println("testFindAll");
                
        List<VoteType> ls = new ArrayList<>();
        ls.add(new VoteType(26));
        ls.add(new VoteType(25));
        
        for (VoteType v : ls) {
            facade().create(v);
        }
        assertEquals(ls, facade().findAll());
    }


}
