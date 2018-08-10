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
import javax.persistence.CascadeType;
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
@Table(name = "redeem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Redeem.findAll", query = "SELECT r FROM Redeem r"),
    @NamedQuery(name = "Redeem.findById", query = "SELECT r FROM Redeem r WHERE r.id = :id"),
    @NamedQuery(name = "Redeem.findByName", query = "SELECT r FROM Redeem r WHERE r.name = :name"),
    @NamedQuery(name = "Redeem.findByDespription", query = "SELECT r FROM Redeem r WHERE r.despription = :despription"),
    @NamedQuery(name = "Redeem.findByAmount", query = "SELECT r FROM Redeem r WHERE r.amount = :amount"),
    @NamedQuery(name = "Redeem.findByCode", query = "SELECT r FROM Redeem r WHERE r.code = :code"),
    @NamedQuery(name = "Redeem.findByMaxUser", query = "SELECT r FROM Redeem r WHERE r.maxUser = :maxUser"),
    @NamedQuery(name = "Redeem.findByCreateDate", query = "SELECT r FROM Redeem r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "Redeem.findByExpireDate", query = "SELECT r FROM Redeem r WHERE r.expireDate = :expireDate")})
public class Redeem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "despription")
    private String despription;
    @Size(max = 45)
    @Column(name = "amount")
    private String amount;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Column(name = "max_user")
    private Integer maxUser;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @JoinColumn(name = "global_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GlobalStatus globalStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redeemId")
    private Collection<RedeemUser> redeemUserCollection;

    public Redeem() {
    }

    public Redeem(Integer id) {
        this.id = id;
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

    public String getDespription() {
        return despription;
    }

    public void setDespription(String despription) {
        this.despription = despription;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public GlobalStatus getGlobalStatusId() {
        return globalStatusId;
    }

    public void setGlobalStatusId(GlobalStatus globalStatusId) {
        this.globalStatusId = globalStatusId;
    }

    @XmlTransient
    public Collection<RedeemUser> getRedeemUserCollection() {
        return redeemUserCollection;
    }

    public void setRedeemUserCollection(Collection<RedeemUser> redeemUserCollection) {
        this.redeemUserCollection = redeemUserCollection;
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
        if (!(object instanceof Redeem)) {
            return false;
        }
        Redeem other = (Redeem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Redeem[ id=" + id + " ]";
    }
    
}
