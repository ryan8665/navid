/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ryan
 */
@Entity
@Table(name = "global_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobalStatus.findAll", query = "SELECT g FROM GlobalStatus g"),
    @NamedQuery(name = "GlobalStatus.findById", query = "SELECT g FROM GlobalStatus g WHERE g.id = :id"),
    @NamedQuery(name = "GlobalStatus.findByName", query = "SELECT g FROM GlobalStatus g WHERE g.name = :name")})
public class GlobalStatus implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<PackageUser> packageUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<Question> questionCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<Package> packageCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<Redeem> redeemCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<Media> mediaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<News> newsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalStatusId")
    private Collection<User> userCollection;

    public GlobalStatus() {
    }

    public GlobalStatus(Integer id) {
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

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof GlobalStatus)) {
            return false;
        }
        GlobalStatus other = (GlobalStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.GlobalStatus[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    @XmlTransient
    public Collection<Media> getMediaCollection() {
        return mediaCollection;
    }

    public void setMediaCollection(Collection<Media> mediaCollection) {
        this.mediaCollection = mediaCollection;
    }

    @XmlTransient
    public Collection<Redeem> getRedeemCollection() {
        return redeemCollection;
    }

    public void setRedeemCollection(Collection<Redeem> redeemCollection) {
        this.redeemCollection = redeemCollection;
    }

    @XmlTransient
    public Collection<Package> getPackageCollection() {
        return packageCollection;
    }

    public void setPackageCollection(Collection<Package> packageCollection) {
        this.packageCollection = packageCollection;
    }

    @XmlTransient
    public Collection<PackageUser> getPackageUserCollection() {
        return packageUserCollection;
    }

    public void setPackageUserCollection(Collection<PackageUser> packageUserCollection) {
        this.packageUserCollection = packageUserCollection;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }
    
}
