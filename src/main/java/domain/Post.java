package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "Post")
@NamedQueries({
    @NamedQuery(name = "Post.findByParentId", query = "SELECT p FROM Post p WHERE p.parentId = :parentId"),
    @NamedQuery(name = "Post.findByPostTypeId", query = "SELECT p FROM Post p WHERE p.postTypeId = :postTypeId")
})
@XmlRootElement
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
    @Column(name = "ownerDisplayName", length = 45, nullable=false)
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
    private List<Post> postChildren;
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne
    private Post parentId;
    @JoinColumn(name = "postTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private PostType postTypeId;
    @JoinColumn(name = "ownerUserId", referencedColumnName = "id")
    @ManyToOne
    private Usuario ownerUserId;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String body, String ownerDisplayName) {
        this.id = id;
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
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

    public String getBody(int end) {
        try {
            return body.substring(0, end).concat("...");
        } catch (Exception e) {
        }
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

    @XmlTransient
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @XmlTransient
    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    @XmlTransient
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

    @XmlTransient
    public List<Post> getPostChildren() {
        return postChildren;
    }

    public void setPostChildren(List<Post> postChildren) {
        this.postChildren = postChildren;
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

    public Usuario getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Usuario ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        if (!Objects.equals(this.ownerDisplayName, other.ownerDisplayName)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ownerUserId, other.ownerUserId)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Post{" + "id=" + getId() + ", ownerDisplayName=" + getOwnerDisplayName() + ", title=" + getTitle() + ", postTypeId=" + postTypeId + '}';
    }

}
