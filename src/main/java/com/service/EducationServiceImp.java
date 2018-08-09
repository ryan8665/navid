/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Chapter;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class EducationServiceImp implements EducationService{

    @Override
    public List<Chapter> getAllChapter() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Chapter> chapterList = session.createCriteria(Chapter.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return chapterList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
