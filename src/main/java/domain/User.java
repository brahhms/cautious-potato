/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByCreationDate", query = "SELECT u FROM User u WHERE u.creationDate = :creationDate")
    , @NamedQuery(name = "User.findByDisplayName", query = "SELECT u FROM User u WHERE u.displayName = :displayName")
    , @NamedQuery(name = "User.findByUpVotes", query = "SELECT u FROM User u WHERE u.upVotes = :upVotes")
    , @NamedQuery(name = "User.findByDownVotes", query = "SELECT u FROM User u WHERE u.downVotes = :downVotes")
    , @NamedQuery(name = "User.findByProfileImageUrl", query = "SELECT u FROM User u WHERE u.profileImageUrl = :profileImageUrl")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status")
    , @NamedQuery(name = "User.findByLastAccessDate", query = "SELECT u FROM User u WHERE u.lastAccessDate = :lastAccessDate")
    , @NamedQuery(name = "User.findByReputation", query = "SELECT u FROM User u WHERE u.reputation = :reputation")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String displayName;
    private Integer upVotes;
    private Integer downVotes;
    @Size(max = 512)
    private String profileImageUrl;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String email;
    @Basic(optional = false)
    @NotNull
    private int status;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastAccessDate;
    private Integer reputation;
    @OneToMany(mappedBy = "ownerUserId")
    private List<Answer> answerList;
    @OneToMany(mappedBy = "userId")
    private List<Comment> commentList;
    @OneToMany(mappedBy = "userId")
    private List<Vote> voteList;
    @OneToMany(mappedBy = "ownerUserId")
    private List<Question> questionList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, Date creationDate, String displayName, String email, int status, Date lastAccessDate) {
        this.id = id;
        this.creationDate = creationDate;
        this.displayName = displayName;
        this.email = email;
        this.status = status;
        this.lastAccessDate = lastAccessDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.User[ id=" + id + " ]";
    }
    
}
