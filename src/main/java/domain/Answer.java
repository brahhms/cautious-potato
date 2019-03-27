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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
    , @NamedQuery(name = "Answer.findById", query = "SELECT a FROM Answer a WHERE a.id = :id")
    , @NamedQuery(name = "Answer.findByCreationDate", query = "SELECT a FROM Answer a WHERE a.creationDate = :creationDate")
    , @NamedQuery(name = "Answer.findByScore", query = "SELECT a FROM Answer a WHERE a.score = :score")
    , @NamedQuery(name = "Answer.findByBody", query = "SELECT a FROM Answer a WHERE a.body = :body")
    , @NamedQuery(name = "Answer.findByOwnerDisplayName", query = "SELECT a FROM Answer a WHERE a.ownerDisplayName = :ownerDisplayName")
    , @NamedQuery(name = "Answer.findByTitle", query = "SELECT a FROM Answer a WHERE a.title = :title")})
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    private int score;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String body;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String ownerDisplayName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String title;
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Question parentId;
    @JoinColumn(name = "ownerUserId", referencedColumnName = "id")
    @ManyToOne
    private User ownerUserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answerId")
    private List<Comment> commentList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "acceptedAnswerId")
    private Question question;

    public Answer() {
    }

    public Answer(Integer id) {
        this.id = id;
    }

    public Answer(Integer id, Date creationDate, int score, String body, String ownerDisplayName, String title) {
        this.id = id;
        this.creationDate = creationDate;
        this.score = score;
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
        this.title = title;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Question getParentId() {
        return parentId;
    }

    public void setParentId(Question parentId) {
        this.parentId = parentId;
    }

    public User getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(User ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Answer[ id=" + id + " ]";
    }
    
}
