
package services;

import domain.User;
import eis.UserFacade;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface UserService {
    
    public List<User> getAllUsers();
    
    public void createUser(User user);
    
    public boolean isActive(int id);

    public void increaseReputation(int id,int amount);
    
    public void decreaseReputacion(int id,int amount);
    
    public boolean exists(String email);
    
    public boolean exists(int id);
        
    public void deleteUser(int id);
    
    public void updateUser(User user);
    
    public void setUserFacade(UserFacade userFacade) ;
    
}