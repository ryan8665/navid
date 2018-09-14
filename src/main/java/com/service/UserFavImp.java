/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.UserFav;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class UserFavImp implements UserFavo{

    @Override
    public List<UserFav> retriveAllUsersByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<com.entity.UserFav> userFavList = session.createCriteria(com.entity.UserFav.class)
                    .add(Restrictions.eq("userId.id", id))
                    .addOrder(Order.asc("id"))
                    .list();
            return userFavList;
        } catch (Exception e) {
            System.out.println("com.service.UserFavImp.retriveAllUsersByUserId() " + e.toString());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void addUser(UserFav userFav) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userFav);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        session.clear();
        Query query = session.createQuery("DELETE FROM UserFav AS r WHERE r.id = " + id);

        session.beginTransaction();
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public UserFav geUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            UserFav userFav = (UserFav) session.get(UserFav.class, id);
            return userFav;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }
    
}
