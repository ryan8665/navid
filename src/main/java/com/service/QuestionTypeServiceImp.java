/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.QuestionType;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class QuestionTypeServiceImp implements QuestionTypeService {

    @Override
    public List<QuestionType> getAllQuestionType() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<QuestionType> questionType = session.createCriteria(QuestionType.class)
                    .addOrder(Order.asc("name"))
                    .list();
            return questionType;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

}
