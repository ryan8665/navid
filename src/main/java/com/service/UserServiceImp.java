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
    
}
