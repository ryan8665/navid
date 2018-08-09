/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ryan
 */
@Entity
@Table(name = "redeem_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeemUser.findAll", query = "SELECT r FROM RedeemUser r")
    , @NamedQuery(name = "RedeemUser.findById", query = "SELECT r FROM RedeemUser r WHERE r.id = :id")
    , @NamedQuery(name = "RedeemUser.findByDescription", query = "SELECT r FROM RedeemUser r WHERE r.description = :description")
    , @NamedQuery(name = "RedeemUser.findByDuoDate", query = "SELECT r FROM RedeemUser r WHERE r.duoDate = :duoDate")})
public class RedeemUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Column(name = "duo_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duoDate;
    @JoinColumn(name = "redeem_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Redeem redeemId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(mappedBy = "redeemUserId")
    private Collection<Transaction> transactionCollection;

    public RedeemUser() {
    }

    public RedeemUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDuoDate() {
        return duoDate;
    }

    public void setDuoDate(Date duoDate) {
        this.duoDate = duoDate;
    }

    public Redeem getRedeemId() {
        return redeemId;
    }

    public void setRedeemId(Redeem redeemId) {
        this.redeemId = redeemId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
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
        if (!(object instanceof RedeemUser)) {
            return false;
        }
        RedeemUser other = (RedeemUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.RedeemUser[ id=" + id + " ]";
    }
    
}
