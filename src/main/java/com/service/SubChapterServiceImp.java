/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.SubChapter;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class SubChapterServiceImp implements SubChapterService{

    @Override
    public List<SubChapter> getAllSubChapter() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<SubChapter> subChapter = session.createCriteria(SubChapter.class)
                    .addOrder(Order.asc("name"))
                    .list();
            return subChapter;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public SubChapter getSubChapterDetaile(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SubChapter subChapter = (SubChapter) session.get(SubChapter.class, id);
            return subChapter;
        } catch (Exception e) {
            System.out.println("com.service.SubChapterServiceImp.getSubChapterDetaile(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveSubChapter(SubChapter subChapter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(subChapter);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int saveSubChapterRetriveID(SubChapter subChapter) {
        int id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(subChapter);
        id = subChapter.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }
    
}
