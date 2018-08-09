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
@Table(name = "general_exam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralExam.findAll", query = "SELECT g FROM GeneralExam g")
    , @NamedQuery(name = "GeneralExam.findById", query = "SELECT g FROM GeneralExam g WHERE g.id = :id")
    , @NamedQuery(name = "GeneralExam.findByCreationDate", query = "SELECT g FROM GeneralExam g WHERE g.creationDate = :creationDate")
    , @NamedQuery(name = "GeneralExam.findByExpireDate", query = "SELECT g FROM GeneralExam g WHERE g.expireDate = :expireDate")
    , @NamedQuery(name = "GeneralExam.findByDueDate", query = "SELECT g FROM GeneralExam g WHERE g.dueDate = :dueDate")
    , @NamedQuery(name = "GeneralExam.findByName", query = "SELECT g FROM GeneralExam g WHERE g.name = :name")
    , @NamedQuery(name = "GeneralExam.findByDescription", query = "SELECT g FROM GeneralExam g WHERE g.description = :description")})
public class GeneralExam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "creation_date")
    private String creationDate;
    @Column(name = "expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "name")
    @Temporal(TemporalType.TIMESTAMP)
    private Date name;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalExamId")
    private Collection<GeneralExamUser> generalExamUserCollection;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lesson lessonId;

    public GeneralExam() {
    }

    public GeneralExam(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getName() {
        return name;
    }

    public void setName(Date name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<GeneralExamUser> getGeneralExamUserCollection() {
        return generalExamUserCollection;
    }

    public void setGeneralExamUserCollection(Collection<GeneralExamUser> generalExamUserCollection) {
        this.generalExamUserCollection = generalExamUserCollection;
    }

    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
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
        if (!(object instanceof GeneralExam)) {
            return false;
        }
        GeneralExam other = (GeneralExam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.GeneralExam[ id=" + id + " ]";
    }
    
}
