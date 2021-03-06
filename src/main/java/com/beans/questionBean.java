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
import com.service.FileService;
import com.service.FileServiceImp;
import com.service.HardnessService;
import com.service.HardnessServiceImp;
import com.service.ImportanceService;
import com.service.ImportanceServiceImp;
import com.service.QuestionService;
import com.service.QuestionServiceImp;
import com.utility.XlsParser;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
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
    private String vquestion, vanswerA, vanswerB, vanswerC, vanswerD, vnote, vdescription;
    private boolean disable = true;
    private int id;

    public String getVquestion() {
        return vquestion;
    }

    public void setVquestion(String vquestion) {
        this.vquestion = vquestion;
    }

    public String getVanswerA() {
        return vanswerA;
    }

    public void setVanswerA(String vanswerA) {
        this.vanswerA = vanswerA;
    }

    public String getVanswerB() {
        return vanswerB;
    }

    public void setVanswerB(String vanswerB) {
        this.vanswerB = vanswerB;
    }

    public String getVanswerC() {
        return vanswerC;
    }

    public void setVanswerC(String vanswerC) {
        this.vanswerC = vanswerC;
    }

    public String getVanswerD() {
        return vanswerD;
    }

    public void setVanswerD(String vanswerD) {
        this.vanswerD = vanswerD;
    }

    public String getVnote() {
        return vnote;
    }

    public void setVnote(String vnote) {
        this.vnote = vnote;
    }

    public String getVdescription() {
        return vdescription;
    }

    public void setVdescription(String vdescription) {
        this.vdescription = vdescription;
    }

    
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
        info("ثبت شد.");
    }
    
    public void doSave(Question oq){
        System.out.println("com.beans.questionBean.saveQuestion()ssssssssssssssssssssssssssssssssssssssssssss");
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        questionServiceImp.saveQuestion(oq);
     
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Question) event.getObject()).getId();
        QuestionService questionServiceImp = new QuestionServiceImp();
        Question question = questionServiceImp.getQuestionDetaile(id);
        vquestion  = question.getQuestion();
        vanswerA =question.getAnswerA();
        vanswerB = question .getAnswerB();
        vanswerC = question.getAnswerC();
        vanswerD = question.getAnswerD();
        vnote = question.getNote();
        vdescription =question.getDescription();
        
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
    
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FileService fileService = new FileServiceImp();
        FacesMessage message = new FacesMessage("آپلود شد", " آپلود شد.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        ServletContext ctx = (ServletContext) FacesContext
                .getCurrentInstance().getExternalContext().getContext();
        String absoluteDiskPath = ctx.getRealPath("/resources/files/");
        System.out.println("----------- " + absoluteDiskPath);
        fileService.copyStream(event.getFile().getInputstream(), absoluteDiskPath + "/"+getUserID() ,"xls");
        List<Question> qList =  XlsParser.doPars(absoluteDiskPath + "/"+getUserID()+".xls");
        for (Question question1 : qList) {
            doSave(question1);
        }
        info("ثبت شد.");

    }
    
}
