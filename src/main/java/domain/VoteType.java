/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abraham
 */
@Entity
@Table(catalog = "QxA", schema = "",name = "VoteType")
@NamedQueries({
    @NamedQuery(name = "VoteType.findAll", query = "SELECT v FROM VoteType v")
    , @NamedQuery(name = "VoteType.findById", query = "SELECT v FROM VoteType v WHERE v.id = :id")
    , @NamedQuery(name = "VoteType.findByName", query = "SELECT v FROM VoteType v WHERE v.name = :name")})
public class VoteType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voteTypeId")
    private List<Vote> voteList;

    public VoteType() {
    }

    public VoteType(Integer id) {
        this.id = id;
    }

    public VoteType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
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
        if (!(object instanceof VoteType)) {
            return false;
        }
        VoteType other = (VoteType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.VoteType[ id=" + id + " ]";
    }
    
}
