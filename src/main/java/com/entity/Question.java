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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id"),
    @NamedQuery(name = "Question.findByQuestion", query = "SELECT q FROM Question q WHERE q.question = :question"),
    @NamedQuery(name = "Question.findByAnswerA", query = "SELECT q FROM Question q WHERE q.answerA = :answerA"),
    @NamedQuery(name = "Question.findByAnswerB", query = "SELECT q FROM Question q WHERE q.answerB = :answerB"),
    @NamedQuery(name = "Question.findByAnswerC", query = "SELECT q FROM Question q WHERE q.answerC = :answerC"),
    @NamedQuery(name = "Question.findByAnswerD", query = "SELECT q FROM Question q WHERE q.answerD = :answerD"),
    @NamedQuery(name = "Question.findByAnswer", query = "SELECT q FROM Question q WHERE q.answer = :answer"),
    @NamedQuery(name = "Question.findByDescription", query = "SELECT q FROM Question q WHERE q.description = :description"),
    @NamedQuery(name = "Question.findByNote", query = "SELECT q FROM Question q WHERE q.note = :note"),
    @NamedQuery(name = "Question.findByTime", query = "SELECT q FROM Question q WHERE q.time = :time")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "question")
    private String question;
    @Size(max = 200)
    @Column(name = "answer_a")
    private String answerA;
    @Size(max = 200)
    @Column(name = "answer_b")
    private String answerB;
    @Size(max = 200)
    @Column(name = "answer_c")
    private String answerC;
    @Size(max = 200)
    @Column(name = "answer_d")
    private String answerD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "answer")
    private int answer;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "note")
    private String note;
    @Column(name = "time")
    private Integer time;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private Collection<ExamQuestionAnswer> examQuestionAnswerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private Collection<Tag> tagCollection;
    @JoinColumn(name = "global_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GlobalStatus globalStatusId;
    @JoinColumn(name = "hadrdness_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hadrdness hadrdnessId;
    @JoinColumn(name = "importance_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Importance importanceId;
    @JoinColumn(name = "question_type_id", referencedColumnName = "id")
    @ManyToOne
    private QuestionType questionTypeId;
    @JoinColumn(name = "sub_chapter_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChapter subChapterId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Question() {
    }

    public Question(Integer id) {
        this.id = id;
    }

    public Question(Integer id, int answer) {
        this.id = id;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @XmlTransient
    public Collection<ExamQuestionAnswer> getExamQuestionAnswerCollection() {
        return examQuestionAnswerCollection;
    }

    public void setExamQuestionAnswerCollection(Collection<ExamQuestionAnswer> examQuestionAnswerCollection) {
        this.examQuestionAnswerCollection = examQuestionAnswerCollection;
    }

    @XmlTransient
    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    public GlobalStatus getGlobalStatusId() {
        return globalStatusId;
    }

    public void setGlobalStatusId(GlobalStatus globalStatusId) {
        this.globalStatusId = globalStatusId;
    }

    public Hadrdness getHadrdnessId() {
        return hadrdnessId;
    }

    public void setHadrdnessId(Hadrdness hadrdnessId) {
        this.hadrdnessId = hadrdnessId;
    }

    public Importance getImportanceId() {
        return importanceId;
    }

    public void setImportanceId(Importance importanceId) {
        this.importanceId = importanceId;
    }

    public QuestionType getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(QuestionType questionTypeId) {
        this.questionTypeId = questionTypeId;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Question[ id=" + id + " ]";
    }
    
}
