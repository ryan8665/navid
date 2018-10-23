/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Category;
import com.entity.Chapter;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class ChapterServiceImp implements ChapterService{

    @Override
    public List<Chapter> getAllChapter() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Chapter> chapter = session.createCriteria(Chapter.class)
                    .addOrder(Order.asc("name"))
                    .list();
            return chapter;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Chapter getChapterDetaile(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Chapter chapter = (Chapter) session.get(Chapter.class, id);
            return chapter;
        } catch (Exception e) {
            System.out.println("com.service.ChapterServiceImp.getChapterDetaile(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveChapter(Chapter chapter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(chapter);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int saveChapterRetriveID(Chapter chapter) {
        int id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(chapter);
        id = chapter.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }
    
}
