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
                    .addOrder(Order.asc("name"))
                    .list();
            return courseList;
        } catch (Exception e) {
            System.out.println("com.service.CourseServiceImp.getAllCourse() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public Course getCourseDetaile(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Course course = (Course) session.get(Course.class, id);
            return course;
        } catch (Exception e) {
            System.out.println("com.service.CourseServiceImp.getCourseDetaile(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int saveCourseRetriveID(Course course) {
        int id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(course);
        id = course.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

}
