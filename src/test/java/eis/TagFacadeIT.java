package eis;

import domain.Tag;
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
public class TagFacadeIT extends AbstractTest<Tag> {

    @Inject
    private TagFacade cut;
    List<Tag> datos = new ArrayList<>();

    public TagFacadeIT() {
        datos.add(new Tag(1, "up"));
        datos.add(new Tag(5, "down"));
        datos.add(new Tag(1, "favorite"));
        this.idNuevo = 5;
    }

    @Override
    protected AbstractFacade facade() {
        return cut;
    }

    @Override
    protected List<Tag> getRegistros() {
        return datos;

    }

    @Override
    protected Object getId() {
        return entity.getId();
    }

}
