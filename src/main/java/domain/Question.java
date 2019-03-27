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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
    , @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id")
    , @NamedQuery(name = "Question.findByCreationDate", query = "SELECT q FROM Question q WHERE q.creationDate = :creationDate")
    , @NamedQuery(name = "Question.findByBody", query = "SELECT q FROM Question q WHERE q.body = :body")
    , @NamedQuery(name = "Question.findByOwnerDisplayName", query = "SELECT q FROM Question q WHERE q.ownerDisplayName = :ownerDisplayName")
    , @NamedQuery(name = "Question.findByTitle", query = "SELECT q FROM Question q WHERE q.title = :title")
    , @NamedQuery(name = "Question.findByAnswerCount", query = "SELECT q FROM Question q WHERE q.answerCount = :answerCount")})
public class Question implements Serializable {

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
    @Size(min = 1, max = 1024)
    private String body;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String ownerDisplayName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    private String title;
    private Integer answerCount;
    @JoinTable(name = "QuestionTag", joinColumns = {
        @JoinColumn(name = "questionId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tagId", referencedColumnName = "id")})
    @ManyToMany
    private List<Tag> tagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
    private List<Answer> answerList;
    @JoinColumn(name = "acceptedAnswerId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Answer acceptedAnswerId;
    @JoinColumn(name = "ownerUserId", referencedColumnName = "id")
    @ManyToOne
    private User ownerUserId;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, Date creationDate, String body, String ownerDisplayName, String title) {
        this.id = id;
        this.creationDate = creationDate;
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

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Answer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Answer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public User getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(User ownerUserId) {
        this.ownerUserId = ownerUserId;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Question[ id=" + id + " ]";
    }
    
}
