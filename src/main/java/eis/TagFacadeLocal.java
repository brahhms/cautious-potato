
package eis;

import domain.Tag;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface TagFacadeLocal {

    void create(Tag tag);

    void edit(Tag tag);

    void remove(Tag tag);

    Tag find(Object id);

    List<Tag> findAll();

    List<Tag> findRange(int[] range);

    int count();
    
}
