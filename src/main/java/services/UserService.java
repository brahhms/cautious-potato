
package services;

import beans.model.UserBean;
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
    
    public void createUser(UserBean user);
    
    public boolean isActive(int id);

    public void increaseReputation(int id,int amount);
    
    public void decreaseReputacion(int id,int amount);
    
    public User getUserById(int id);
    
    public boolean exists(String email);
    
    public boolean exists(int id);
        
    public void deleteUser(int id);
    
    public void updateUser(UserBean user);
    
    
}