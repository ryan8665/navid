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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "exam_question_answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamQuestionAnswer.findAll", query = "SELECT e FROM ExamQuestionAnswer e")
    , @NamedQuery(name = "ExamQuestionAnswer.findById", query = "SELECT e FROM ExamQuestionAnswer e WHERE e.id = :id")
    , @NamedQuery(name = "ExamQuestionAnswer.findByDueDate", query = "SELECT e FROM ExamQuestionAnswer e WHERE e.dueDate = :dueDate")})
public class ExamQuestionAnswer implements Serializable {

    @Lob
    @Column(name = "answer")
    private byte[] answer;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Exam examId;
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Question questionId;

    public ExamQuestionAnswer() {
    }

    public ExamQuestionAnswer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
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
        if (!(object instanceof ExamQuestionAnswer)) {
            return false;
        }
        ExamQuestionAnswer other = (ExamQuestionAnswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ExamQuestionAnswer[ id=" + id + " ]";
    }

    public byte[] getAnswer() {
        return answer;
    }

    public void setAnswer(byte[] answer) {
        this.answer = answer;
    }
    
}
