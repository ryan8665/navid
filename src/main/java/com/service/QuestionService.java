/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Question;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface QuestionService {
    
    public List<Question> getAllQuestion();
    
    public List<Question> getAllQuestionByUser(int id);

    public Question getQuestionDetaile(int id);

    public void saveQuestion(Question question);
    
}
