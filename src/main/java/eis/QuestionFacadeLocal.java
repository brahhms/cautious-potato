
package eis;

import domain.Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface QuestionFacadeLocal {

    void create(Question question);

    void edit(Question question);

    void remove(Question question);

    Question find(Object id);

    List<Question> findAll();

    List<Question> findRange(int[] range);

    int count();
    
}
