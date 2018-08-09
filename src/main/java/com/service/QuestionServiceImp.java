/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Question;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class QuestionServiceImp implements QuestionService{

    @Override
    public List<Question> getAllQuestion() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Question> question = session.createCriteria(Question.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return question;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Question> getAllQuestionByUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Question> question = session.createCriteria(Question.class)
                    .add(Restrictions.eq("userId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return question;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Question getQuestionDetaile(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Question question = (Question) session.get(Question.class, id);
            return question;
        } catch (Exception e) {
            System.out.println("com.service.QuestionServiceImp.getQuestionDetaile(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveQuestion(Question question) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(question);
        session.getTransaction().commit();
        session.close();
    }
    
}
