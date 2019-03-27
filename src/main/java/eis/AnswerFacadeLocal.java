
package eis;

import domain.Answer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface AnswerFacadeLocal {

    void create(Answer answer);

    void edit(Answer answer);

    void remove(Answer answer);

    Answer find(Object id);

    List<Answer> findAll();

    List<Answer> findRange(int[] range);

    int count();
    
}
