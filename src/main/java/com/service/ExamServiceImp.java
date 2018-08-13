/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.ExamType;
import com.entity.GeneralExam;
import com.entity.GeneralExamUser;
import com.utility.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author ryan
 */
public class ExamServiceImp implements ExamService{

    @Override
    public List<GeneralExam> getGeneralExam() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<GeneralExam> generalExamList = session.createCriteria(GeneralExam.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return generalExamList;
        } catch (Exception e) {
            System.out.println("com.service.UserServiceImp.getAllStudent " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<GeneralExamUser> getGeneralExamByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<GeneralExamUser> generalExamList = session.createCriteria(GeneralExamUser.class)
                    .add(Restrictions.eq("userId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return generalExamList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<ExamType> getAllExamType() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<ExamType> examTypeList = session.createCriteria(ExamType.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return examTypeList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

   
    
}
