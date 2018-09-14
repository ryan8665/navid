/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ryan
 */
@Entity
@Table(name = "hardness_defaults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HardnessDefaults.findAll", query = "SELECT h FROM HardnessDefaults h"),
    @NamedQuery(name = "HardnessDefaults.findById", query = "SELECT h FROM HardnessDefaults h WHERE h.id = :id"),
    @NamedQuery(name = "HardnessDefaults.findByEasy", query = "SELECT h FROM HardnessDefaults h WHERE h.easy = :easy"),
    @NamedQuery(name = "HardnessDefaults.findByMedume", query = "SELECT h FROM HardnessDefaults h WHERE h.medume = :medume"),
    @NamedQuery(name = "HardnessDefaults.findByHard", query = "SELECT h FROM HardnessDefaults h WHERE h.hard = :hard"),
    @NamedQuery(name = "HardnessDefaults.findByVeryHard", query = "SELECT h FROM HardnessDefaults h WHERE h.veryHard = :veryHard"),
    @NamedQuery(name = "HardnessDefaults.findByDate", query = "SELECT h FROM HardnessDefaults h WHERE h.date = :date")})
public class HardnessDefaults implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "easy")
    private Integer easy;
    @Column(name = "medume")
    private Integer medume;
    @Column(name = "hard")
    private Integer hard;
    @Column(name = "very_hard")
    private Integer veryHard;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public HardnessDefaults() {
    }

    public HardnessDefaults(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEasy() {
        return easy;
    }

    public void setEasy(Integer easy) {
        this.easy = easy;
    }

    public Integer getMedume() {
        return medume;
    }

    public void setMedume(Integer medume) {
        this.medume = medume;
    }

    public Integer getHard() {
        return hard;
    }

    public void setHard(Integer hard) {
        this.hard = hard;
    }

    public Integer getVeryHard() {
        return veryHard;
    }

    public void setVeryHard(Integer veryHard) {
        this.veryHard = veryHard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        if (!(object instanceof HardnessDefaults)) {
            return false;
        }
        HardnessDefaults other = (HardnessDefaults) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.HardnessDefaults[ id=" + id + " ]";
    }
    
}
