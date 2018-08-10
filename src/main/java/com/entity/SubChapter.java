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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ryan
 */
@Entity
@Table(name = "sub_chapter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubChapter.findAll", query = "SELECT s FROM SubChapter s"),
    @NamedQuery(name = "SubChapter.findById", query = "SELECT s FROM SubChapter s WHERE s.id = :id"),
    @NamedQuery(name = "SubChapter.findByName", query = "SELECT s FROM SubChapter s WHERE s.name = :name"),
    @NamedQuery(name = "SubChapter.findByDescription", query = "SELECT s FROM SubChapter s WHERE s.description = :description"),
    @NamedQuery(name = "SubChapter.findBySequence", query = "SELECT s FROM SubChapter s WHERE s.sequence = :sequence")})
public class SubChapter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "sequence")
    private Integer sequence;
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Chapter chapterId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subChapterId")
    private Collection<Question> questionCollection;
    @OneToMany(mappedBy = "subChapterId")
    private Collection<Exam> examCollection;

    public SubChapter() {
    }

    public SubChapter(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Chapter getChapterId() {
        return chapterId;
    }

    public void setChapterId(Chapter chapterId) {
        this.chapterId = chapterId;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @XmlTransient
    public Collection<Exam> getExamCollection() {
        return examCollection;
    }

    public void setExamCollection(Collection<Exam> examCollection) {
        this.examCollection = examCollection;
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
        if (!(object instanceof SubChapter)) {
            return false;
        }
        SubChapter other = (SubChapter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.SubChapter[ id=" + id + " ]";
    }
    
}
