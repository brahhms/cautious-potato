
package eis;

import domain.TagSynonym;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface TagSynonymFacadeLocal {

    void create(TagSynonym tagSynonym);

    void edit(TagSynonym tagSynonym);

    void remove(TagSynonym tagSynonym);

    TagSynonym find(Object id);

    List<TagSynonym> findAll();

    List<TagSynonym> findRange(int[] range);

    int count();
    
}
