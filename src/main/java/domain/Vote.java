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

/**
 *
 * @author abraham
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v")
    , @NamedQuery(name = "Vote.findById", query = "SELECT v FROM Vote v WHERE v.id = :id")
    , @NamedQuery(name = "Vote.findByPostId", query = "SELECT v FROM Vote v WHERE v.postId = :postId")
    , @NamedQuery(name = "Vote.findByCreationDate", query = "SELECT v FROM Vote v WHERE v.creationDate = :creationDate")
    , @NamedQuery(name = "Vote.findByBountyAmount", query = "SELECT v FROM Vote v WHERE v.bountyAmount = :bountyAmount")})
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private int postId;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    private Integer bountyAmount;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "voteTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoteType voteTypeId;

    public Vote() {
    }

    public Vote(Integer id) {
        this.id = id;
    }

    public Vote(Integer id, int postId, Date creationDate) {
        this.id = id;
        this.postId = postId;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(Integer bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Vote[ id=" + id + " ]";
    }
    
}
