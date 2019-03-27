
package eis;

import domain.Vote;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface VoteFacadeLocal {

    void create(Vote vote);

    void edit(Vote vote);

    void remove(Vote vote);

    Vote find(Object id);

    List<Vote> findAll();

    List<Vote> findRange(int[] range);

    int count();
    
}
