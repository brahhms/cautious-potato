package services;

import beans.model.UserBean;
import domain.User;
import eis.UserFacadeLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author abraham
 */
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserFacadeLocal userFacade;

    @Override
    public List<User> getAll() {
        return userFacade.findAll();
    }

    @Override
    public void create(UserBean u) {

        User user = new User();
        user.setDisplayName(u.getDisplayName());
        user.setEmail(u.getEmail());
        user.setProfileImageUrl(u.getProfileImageUrl());
        userFacade.create(user);
        
    }

    @Override
    public boolean isActive(int id) {
        User user = userFacade.find(new User(id));
        return user.getStatus()==1 ;
    }


    @Override
    public void increaseReputation(int id, int amount) {
        User user = userFacade.find(new User(id));
        user.setReputation(
                user.getReputation()+amount); 
        userFacade.edit(user);
    }

    @Override
    public void decreaseReputacion(int id, int amount) {
        User user = userFacade.find(new User(id));
        user.setReputation(
                user.getReputation()-amount); 
        userFacade.edit(user);
    }

    @Override
    public User getById(int id) {
        return userFacade.find(new User(id));
    }

    @Override
    public boolean exists(String email) {
        try {
            userFacade.findUserByEmail(email);
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

        @Override
    public boolean exists(int id) {
        try {
            userFacade.find(new User(id));
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }
    
    @Override
    public void delete(int id) {
        User user = new User(id);
        user.setDisplayName( userFacade.findDisplayNameById(id) );
        user.setStatus(0);
        userFacade.edit(user);
    }

    @Override
    public void update(UserBean u) {
        User user = userFacade.find(u.getId());
        user.setDisplayName(u.getDisplayName());
        user.setEmail(u.getEmail());
        user.setProfileImageUrl(u.getProfileImageUrl());
        userFacade.edit(user);
    }


}
