
package domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(name = "TagSynonym")
public class TagSynonym implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String tagSynonym;
    @JoinColumn(name = "tagId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tag tagId;

    public TagSynonym() {
    }

    public TagSynonym(Integer id) {
        this.id = id;
    }

    public TagSynonym(Integer id, String tagSynonym) {
        this.id = id;
        this.tagSynonym = tagSynonym;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagSynonym() {
        return tagSynonym;
    }

    public void setTagSynonym(String tagSynonym) {
        this.tagSynonym = tagSynonym;
    }

    public Tag getTagId() {
        return tagId;
    }

    public void setTagId(Tag tagId) {
        this.tagId = tagId;
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
        final TagSynonym other = (TagSynonym) obj;
        if (!Objects.equals(this.tagSynonym, other.tagSynonym)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.tagId, other.tagId)) {
            return false;
        }
        return true;
    }


    
    @Override
    public String toString() {
        return "TagSynonym{" + "id=" + getId() + ", tagSynonym=" + getTagSynonym() + ", tagId=" + getTagId() + '}';
    }

 
}
