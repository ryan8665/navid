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
import javax.persistence.Lob;
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
@Table(name = "rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r"),
    @NamedQuery(name = "Rule.findById", query = "SELECT r FROM Rule r WHERE r.id = :id"),
    @NamedQuery(name = "Rule.findByName", query = "SELECT r FROM Rule r WHERE r.name = :name"),
    @NamedQuery(name = "Rule.findByDespription", query = "SELECT r FROM Rule r WHERE r.despription = :despription")})
public class Rule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "despription")
    private String despription;
    @Lob
    @Column(name = "view")
    private byte[] view;
    @Lob
    @Column(name = "insert")
    private byte[] insert;
    @Lob
    @Column(name = "update")
    private byte[] update;
    @Lob
    @Column(name = "delete")
    private byte[] delete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruleId")
    private Collection<UserRule> userRuleCollection;

    public Rule() {
    }

    public Rule(Integer id) {
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

    public byte[] getView() {
        return view;
    }

    public void setView(byte[] view) {
        this.view = view;
    }

    public byte[] getInsert() {
        return insert;
    }

    public void setInsert(byte[] insert) {
        this.insert = insert;
    }

    public byte[] getUpdate() {
        return update;
    }

    public void setUpdate(byte[] update) {
        this.update = update;
    }

    public byte[] getDelete() {
        return delete;
    }

    public void setDelete(byte[] delete) {
        this.delete = delete;
    }

    @XmlTransient
    public Collection<UserRule> getUserRuleCollection() {
        return userRuleCollection;
    }

    public void setUserRuleCollection(Collection<UserRule> userRuleCollection) {
        this.userRuleCollection = userRuleCollection;
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
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Rule[ id=" + id + " ]";
    }
    
}
