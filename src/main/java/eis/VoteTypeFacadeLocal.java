
package eis;

import domain.VoteType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface VoteTypeFacadeLocal {

    void create(VoteType voteType);

    void edit(VoteType voteType);

    void remove(VoteType voteType);

    VoteType find(Object id);

    List<VoteType> findAll();

    List<VoteType> findRange(int[] range);

    int count();
    
}
