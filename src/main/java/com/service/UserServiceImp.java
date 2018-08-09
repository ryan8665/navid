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
public class UserServiceImp implements UserService{

    @Override
    public List<User> getAllUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<User> userList = session.createCriteria(User.class)
                    .addOrder(Order.asc("id"))
                    .list();
            return userList;
        } catch (Exception e) {
            System.out.println("com.service.UserServiceImp.getAllUser " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<User> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<User> userList = session.createCriteria(User.class)
                    .add(Restrictions.eq("userTypeId.id", 3))
                    .addOrder(Order.desc("id"))
                    .list();
            return userList;
        } catch (Exception e) {
            System.out.println("com.service.UserServiceImp.getAllStudent " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<User> getAllUserNoAdmin() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<User> userList = session.createCriteria(User.class)
                    .add(Restrictions.ne("userTypeId.id", 1))
                    .addOrder(Order.desc("id"))
                    .list();
            return userList;
        } catch (Exception e) {
            System.out.println("com.service.UserServiceImp.getAllStudent " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }
    
}
