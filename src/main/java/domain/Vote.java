
package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "Vote")
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "postId", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Post postId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private Usuario userId;
    @JoinColumn(name = "voteTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private VoteType voteTypeId;

    public Vote() {
    }

    public Vote(Integer id) {
        this.id = id;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public Usuario getUserId() {
        return userId;
    }

    public void setUserId(Usuario userId) {
        this.userId = userId;
    }

    public VoteType getVoteTypeId() {
        return voteTypeId;
    }

    public void setVoteTypeId(VoteType voteTypeId) {
        this.voteTypeId = voteTypeId;
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
        final Vote other = (Vote) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.postId, other.postId)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.voteTypeId, other.voteTypeId)) {
            return false;
        }
        return true;
    }


    
    @Override
    public String toString() {
        return "Vote{" + "id=" + getId() + ", postId=" + getPostId() + ", userId=" + getUserId() + ", voteTypeId=" + getVoteTypeId() + '}';
    }


    

}
