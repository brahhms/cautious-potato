
package beans.helper;

import domain.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.UserService;
import services.UserServiceImpl;

/**
 *
 * @author abraham
 */
@Named
@RequestScoped
public class UserServiceBean implements Serializable{
    
    @Inject
    UserService us;  
    private List<User> users;

    @PostConstruct
    public void init() {
        users = us.getAllUsers();
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUs(UserServiceImpl us) {
        this.us = us;
    }


    
    
    
}
