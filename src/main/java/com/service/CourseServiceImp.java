/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Course;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class CourseServiceImp implements CourseService {

    @Override
    public List<Course> getAllCourse() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Course> courseList = session.createCriteria(Course.class)
                    .addOrder(Order.desc("name"))
                    .list();
            return courseList;
        } catch (Exception e) {
            System.out.println("com.service.CourseServiceImp.getAllCourse() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

}
