/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ryan
 */
@Entity
@Table(name = "fav")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fav.findAll", query = "SELECT f FROM Fav f"),
    @NamedQuery(name = "Fav.findByIdfav", query = "SELECT f FROM Fav f WHERE f.idfav = :idfav")})
public class Fav implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfav")
    private Integer idfav;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Fav() {
    }

    public Fav(Integer idfav) {
        this.idfav = idfav;
    }

    public Integer getIdfav() {
        return idfav;
    }

    public void setIdfav(Integer idfav) {
        this.idfav = idfav;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfav != null ? idfav.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fav)) {
            return false;
        }
        Fav other = (Fav) object;
        if ((this.idfav == null && other.idfav != null) || (this.idfav != null && !this.idfav.equals(other.idfav))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Fav[ idfav=" + idfav + " ]";
    }
    
}
