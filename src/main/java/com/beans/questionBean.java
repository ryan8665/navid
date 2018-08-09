/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Question;
import com.service.QuestionServiceImp;
import java.text.ParseException;
import java.util.List;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
public class questionBean extends BaseBean {

    private boolean disable = true;
    private int id;

    public List<Question> getAllQuestion() {
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        return questionServiceImp.getAllQuestion();
    }

    public List<Question> getQuestionByUser() {
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        return questionServiceImp.getAllQuestionByUser(getUserID());
    }

    public Question getQuestionDetaile() {
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        return questionServiceImp.getQuestionDetaile(id);
    }

    public void saveQuestion() {

    }

    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Question) event.getObject()).getId();
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        Question question = questionServiceImp.getQuestionDetaile(id);

    }
    
    public void updateStatus() {
        QuestionServiceImp questionServiceImp = new QuestionServiceImp();
        questionServiceImp.changeQuestionStatus(id);
    }

}
