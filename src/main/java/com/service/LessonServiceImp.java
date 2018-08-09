/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Lesson;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class LessonServiceImp implements  LessonService{

    @Override
    public List<Lesson> getAllLesson() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Lesson> lessonList = session.createCriteria(Lesson.class)
                    .addOrder(Order.desc("name"))
                    .list();
            return lessonList;
        } catch (Exception e) {
            System.out.println("com.service.LessonServiceImp.getAllLesson() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }
    
}
