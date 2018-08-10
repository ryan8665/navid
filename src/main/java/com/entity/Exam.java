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
@Table(name = "exam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findById", query = "SELECT e FROM Exam e WHERE e.id = :id"),
    @NamedQuery(name = "Exam.findByName", query = "SELECT e FROM Exam e WHERE e.name = :name"),
    @NamedQuery(name = "Exam.findByDescription", query = "SELECT e FROM Exam e WHERE e.description = :description"),
    @NamedQuery(name = "Exam.findByCreationDate", query = "SELECT e FROM Exam e WHERE e.creationDate = :creationDate"),
    @NamedQuery(name = "Exam.findByDueDate", query = "SELECT e FROM Exam e WHERE e.dueDate = :dueDate"),
    @NamedQuery(name = "Exam.findByExpireDate", query = "SELECT e FROM Exam e WHERE e.expireDate = :expireDate"),
    @NamedQuery(name = "Exam.findByQuestionNumber", query = "SELECT e FROM Exam e WHERE e.questionNumber = :questionNumber")})
public class Exam implements Serializable {

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
    @Column(name = "description")
    private String description;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "expire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "question_number")
    private Integer questionNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examId")
    private Collection<ExamQuestionAnswer> examQuestionAnswerCollection;
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    @ManyToOne
    private Chapter chapterId;
    @JoinColumn(name = "exam_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ExamType examTypeId;
    @JoinColumn(name = "hadrdness_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hadrdness hadrdnessId;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne
    private Lesson lessonId;
    @JoinColumn(name = "sub_chapter_id", referencedColumnName = "id")
    @ManyToOne
    private SubChapter subChapterId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Exam() {
    }

    public Exam(Integer id) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    @XmlTransient
    public Collection<ExamQuestionAnswer> getExamQuestionAnswerCollection() {
        return examQuestionAnswerCollection;
    }

    public void setExamQuestionAnswerCollection(Collection<ExamQuestionAnswer> examQuestionAnswerCollection) {
        this.examQuestionAnswerCollection = examQuestionAnswerCollection;
    }

    public Chapter getChapterId() {
        return chapterId;
    }

    public void setChapterId(Chapter chapterId) {
        this.chapterId = chapterId;
    }

    public ExamType getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(ExamType examTypeId) {
        this.examTypeId = examTypeId;
    }

    public Hadrdness getHadrdnessId() {
        return hadrdnessId;
    }

    public void setHadrdnessId(Hadrdness hadrdnessId) {
        this.hadrdnessId = hadrdnessId;
    }

    public Lesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(Lesson lessonId) {
        this.lessonId = lessonId;
    }

    public SubChapter getSubChapterId() {
        return subChapterId;
    }

    public void setSubChapterId(SubChapter subChapterId) {
        this.subChapterId = subChapterId;
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
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Exam[ id=" + id + " ]";
    }
    
}
