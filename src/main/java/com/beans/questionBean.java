/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.GlobalStatus;
import com.entity.Hadrdness;
import com.entity.Importance;
import com.entity.Question;
import com.entity.QuestionType;
import com.entity.SubChapter;
import com.entity.User;
import com.service.HardnessService;
import com.service.HardnessServiceImp;
import com.service.ImportanceService;
import com.service.ImportanceServiceImp;
import com.service.QuestionService;
import com.service.QuestionServiceImp;
import java.text.ParseException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class questionBean extends BaseBean {

    private String question, answerA, answerB, answerC, answerD, note, description ,subchapter;
    private int time, importance, hardness, rightAnswer;
    private List<String> tag;
    
    private boolean disable = true;
    private int id;

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }
    
    
    
    public int getRightAnswer() {
        return rightAnswer;
    }
    
    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
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
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getTime() {
        return time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }
    
    public int getImportance() {
        return importance;
    }
    
    public void setImportance(int importance) {
        this.importance = importance;
    }
    
    public int getHardness() {
        return hardness;
    }
    
    public void setHardness(int hardness) {
        this.hardness = hardness;
    }
    
    public String getSubchapter() {
        return subchapter;
    }
    
    public void setSubchapter(String subchapter) {
        this.subchapter = subchapter;
    }
    
    public boolean isDisable() {
        return disable;
    }
    
    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public List<Question> getAllQuestion() {
        QuestionService questionServiceImp = new QuestionServiceImp();
        return questionServiceImp.getAllQuestion();
    }
    
    public List<Question> getQuestionByUser() {
        QuestionService questionServiceImp = new QuestionServiceImp();
        return questionServiceImp.getAllQuestionByUser(getUserID());
    }
    
    public Question getQuestionDetaile() {
        QuestionService questionServiceImp = new QuestionServiceImp();
        return questionServiceImp.getQuestionDetaile(id);
    }
    
    public void saveQuestion() {
        System.out.println("com.beans.questionBean.saveQuestion()ssssssssssssssssssssssssssssssssssssssssssss");
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        Question oq = new Question();
        oq.setAnswer(rightAnswer);
        oq.setAnswerA(answerA);
        oq.setAnswerB(answerB);
        oq.setAnswerC(answerC);
        oq.setAnswerD(answerD);
        oq.setDescription(description);
        oq.setGlobalStatusId(new GlobalStatus(1));
        oq.setHadrdnessId(new Hadrdness(hardness));
        oq.setImportanceId(new Importance(importance));
        //   oq.setQuestionTypeId(new QuestionType(id));
        oq.setQuestion(question);
        oq.setNote(note);
        oq.setSubChapterId(new SubChapter(Integer.parseInt(subchapter)));
        oq.setTime(time);
        oq.setUserId(new User(getUserID()));
        questionServiceImp.saveQuestion(oq);
        
    }
    
    public void doSave(){
     
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Question) event.getObject()).getId();
        QuestionService questionServiceImp = new QuestionServiceImp();
        Question question = questionServiceImp.getQuestionDetaile(id);
        
    }
    
    public void updateStatus() {
        QuestionService questionServiceImp = new QuestionServiceImp();
        questionServiceImp.changeQuestionStatus(id);
    }
    
    public List<Hadrdness> getAllHardness() {
        HardnessService hardnessService = new HardnessServiceImp();
        return hardnessService.getAllHardness();
    }
    
    public List<Importance> getAllImportance() {
        ImportanceService importanceService = new ImportanceServiceImp();
        return importanceService.getAllImportance();
    }
    
}
