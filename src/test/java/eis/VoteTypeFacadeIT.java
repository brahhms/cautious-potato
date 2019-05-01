package eis;

import domain.VoteType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

/**
 *
 * @author abraham
 */
@RunWith(Arquillian.class)
public class VoteTypeFacadeIT extends AbstractTest<VoteType> {

    @Inject
    private VoteTypeFacade cut;
    List<VoteType> datos = new ArrayList<>();

    public VoteTypeFacadeIT() {
        datos.add(new VoteType(1, "up"));
        datos.add(new VoteType(5, "down"));
        datos.add(new VoteType(1, "favorite"));
        this.idNuevo = 5;
    }

    @Override
    protected AbstractFacade facade() {
        return cut;
    }

    @Override
    protected List<VoteType> getRegistros() {
        return datos;

    }

    @Override
    protected Object getId() {
        return entity.getId();
    }

}
