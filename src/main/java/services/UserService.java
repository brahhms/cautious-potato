
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
    
    public List<User> getAll();
    
    public void create(UserBean user);
    
    public boolean isActive(int id);

    public void increaseReputation(int id,int amount);
    
    public void decreaseReputacion(int id,int amount);
    
    public User getById(int id);
    
    public boolean exists(String email);
    
    public boolean exists(int id);
        
    public void delete(int id);
    
    public void update(UserBean user);
    
    
}