/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

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
public class GeneralExamServiceImp implements GeneralExamService{

    @Override
    public List<GeneralExam> getAllGeneralExam() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<GeneralExam> generalExamList = session.createCriteria(GeneralExam.class)
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
    public GeneralExam getGeneralExamDetaile(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            GeneralExam generalExam = (GeneralExam) session.get(GeneralExam.class, id);
            return generalExam;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveGeneralExam(GeneralExam generalExam) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(generalExam);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<GeneralExamUser> getGeneralExamUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<GeneralExamUser> generalExamUserList = session.createCriteria(GeneralExamUser.class)
                    .add(Restrictions.eq("generalExamId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return generalExamUserList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }
    
}
