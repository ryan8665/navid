/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.GlobalStatus;
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

    @Override
    public List<Object[]> cuntUserGroupByUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> res =  (List<Object[]>) session.createSQLQuery("SELECT count(u.`id`) as count , ut.`name` as name  FROM `user` as u inner join user_type as ut on u.`user_type_id` = ut.`id`").list();
        return res;
    }
    
    @Override
    public User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            User user = (User) session.get(User.class, id);
            return user;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void changeUserStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User on = (User) session.get(User.class, id);

        if (on.getGlobalStatusId().getId() == 1) {
            on.setGlobalStatusId(new GlobalStatus(2));
        } else {
            on.setGlobalStatusId(new GlobalStatus(1));
        }

        session.beginTransaction();
        session.update(on);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean chackUserisExist(String mobile) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            User User = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("mobile", mobile)).uniqueResult();
            return User != null;
           
        } catch (Exception e) {
            return false;
        } finally {
            session.close();

        }
    }
    
}
