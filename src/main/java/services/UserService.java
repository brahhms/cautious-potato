
package services;

import domain.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface UserService {
    
    public List<User> getAllUsers();
}
