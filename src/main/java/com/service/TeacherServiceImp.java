/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.User;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class TeacherServiceImp implements TeacherService{

    @Override
    public List<User> getAllTeachers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<User> teacherList = session.createCriteria(User.class)
                    .add(Restrictions.eq("userTypeId.id", 3))
                    .addOrder(Order.desc("name"))
                    .list();
            return teacherList;
        } catch (Exception e) {
            System.out.println("com.service.TeacherServiceImp.getAllTeachers() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }
    
}
