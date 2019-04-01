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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(catalog = "QxA", schema = "",name = "Post")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findByCreationDate", query = "SELECT p FROM Post p WHERE p.creationDate = :creationDate")
    , @NamedQuery(name = "Post.findByBody", query = "SELECT p FROM Post p WHERE p.body = :body")
    , @NamedQuery(name = "Post.findByOwnerDisplayName", query = "SELECT p FROM Post p WHERE p.ownerDisplayName = :ownerDisplayName")
    , @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    private String body;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String ownerDisplayName;
    @Size(min = 1, max = 128)
    private String title;
    @JoinTable(name = "PostTag", joinColumns = {
        @JoinColumn(name = "postId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tagId", referencedColumnName = "id")})
    @ManyToMany
    private List<Tag> tagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private List<Vote> voteList;
    @OneToMany(mappedBy = "acceptedAnswerId")
    private List<Post> postList;
    @JoinColumn(name = "acceptedAnswerId", referencedColumnName = "id")
    @ManyToOne
    private Post acceptedAnswerId;
    @OneToMany(mappedBy = "parentId")
    private List<Post> postList1;
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne
    private Post parentId;
    @JoinColumn(name = "postTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PostType postTypeId;
    @JoinColumn(name = "ownerUserId", referencedColumnName = "id")
    @ManyToOne
    private User ownerUserId;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String body, String ownerDisplayName, String title) {
        this.id = id;
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
        this.title = title;
    }

    //question
    public Post(Integer id, String body, String ownerDisplayName, String title, List<Tag> tagList, User ownerUserId) {
        this.id = id;
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
        this.title = title;
        this.tagList = tagList;
        this.postTypeId = new PostType(1);
        this.ownerUserId = ownerUserId;
    }

    //answer
    public Post(Integer id, String body, String ownerDisplayName, String title, Post parentId, User ownerUserId) {
        this.id = id;
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
        this.title = title;
        this.parentId = parentId;
        this.postTypeId = new PostType(2);
        this.ownerUserId = ownerUserId;
    }

    //comment
    public Post(String body, String ownerDisplayName, Post parentId, User ownerUserId) {
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
        this.parentId = parentId;
        this.postTypeId = new PostType(3);
        this.ownerUserId = ownerUserId;
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

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Post getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Post acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public List<Post> getPostList1() {
        return postList1;
    }

    public void setPostList1(List<Post> postList1) {
        this.postList1 = postList1;
    }

    public Post getParentId() {
        return parentId;
    }

    public void setParentId(Post parentId) {
        this.parentId = parentId;
    }

    public PostType getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(PostType postTypeId) {
        this.postTypeId = postTypeId;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", ownerDisplayName=" + ownerDisplayName + ", title=" + title + ", postTypeId=" + postTypeId + '}';
    }


    
}
