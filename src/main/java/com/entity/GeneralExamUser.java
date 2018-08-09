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
@Table(name = "general_exam_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralExamUser.findAll", query = "SELECT g FROM GeneralExamUser g")
    , @NamedQuery(name = "GeneralExamUser.findById", query = "SELECT g FROM GeneralExamUser g WHERE g.id = :id")
    , @NamedQuery(name = "GeneralExamUser.findByMark", query = "SELECT g FROM GeneralExamUser g WHERE g.mark = :mark")})
public class GeneralExamUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mark")
    private Integer mark;
    @JoinColumn(name = "general_exam_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralExam generalExamId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public GeneralExamUser() {
    }

    public GeneralExamUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public GeneralExam getGeneralExamId() {
        return generalExamId;
    }

    public void setGeneralExamId(GeneralExam generalExamId) {
        this.generalExamId = generalExamId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralExamUser)) {
            return false;
        }
        GeneralExamUser other = (GeneralExamUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.GeneralExamUser[ id=" + id + " ]";
    }
    
}
