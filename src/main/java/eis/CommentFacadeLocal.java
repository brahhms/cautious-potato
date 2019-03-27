
package eis;

import domain.Comment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface CommentFacadeLocal {

    void create(Comment comment);

    void edit(Comment comment);

    void remove(Comment comment);

    Comment find(Object id);

    List<Comment> findAll();

    List<Comment> findRange(int[] range);

    int count();
    
}
