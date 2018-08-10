/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Question;
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

    private boolean disable = true;
    private int id;

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

}
