
package domain;

import java.io.Serializable;
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
@Table(catalog = "QxA", schema = "",name = "TagSynonym")
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

    public Integer getTagId() {
        return tagId.getId();
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagSynonym)) {
            return false;
        }
        TagSynonym other = (TagSynonym) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TagSynonym{" + "id=" + getId() + ", tagSynonym=" + getTagSynonym() + ", tagId=" + getTagId() + '}';
    }

 
}
