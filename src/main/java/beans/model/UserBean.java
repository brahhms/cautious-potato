
package beans.model;


import javax.inject.Named;

/**
 *
 * @author abraham
 */
@Named
public class UserBean {
    private Integer id;

    private String displayName;

    private int upVotes;

    private int downVotes;

    private String profileImageUrl;
 
    private String email;

 
    public UserBean() {
    }
     
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserBean(Integer id ,String displayName, String profileImageUrl, String email) {
        this.id = id;
        this.displayName = displayName;
        this.profileImageUrl = profileImageUrl;
        this.email = email;
    }
    
    
    
}
