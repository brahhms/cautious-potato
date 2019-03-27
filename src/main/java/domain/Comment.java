/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findById", query = "SELECT c FROM Comment c WHERE c.id = :id")
    , @NamedQuery(name = "Comment.findByScore", query = "SELECT c FROM Comment c WHERE c.score = :score")
    , @NamedQuery(name = "Comment.findByText", query = "SELECT c FROM Comment c WHERE c.text = :text")
    , @NamedQuery(name = "Comment.findByCreationDate", query = "SELECT c FROM Comment c WHERE c.creationDate = :creationDate")
    , @NamedQuery(name = "Comment.findByUserDisplayName", query = "SELECT c FROM Comment c WHERE c.userDisplayName = :userDisplayName")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer score;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String text;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String userDisplayName;
    @JoinColumn(name = "answerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Answer answerId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Comment() {
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, String text, Date creationDate, String userDisplayName) {
        this.id = id;
        this.text = text;
        this.creationDate = creationDate;
        this.userDisplayName = userDisplayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public Answer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Answer answerId) {
        this.answerId = answerId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Comment[ id=" + id + " ]";
    }
    
}
