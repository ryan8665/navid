/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Logs;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class LogServiceImp implements LogService{

    @Override
    public List<Logs> getUserLogById(int UserId) {
        System.out.println(UserId);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Logs> logs = session.createCriteria(Logs.class)
                    .add(Restrictions.eq("userId.id", UserId))
                    .addOrder(Order.desc("id"))
                    .list();
            return logs;
        } catch (Exception e) {
            System.out.println("com.service.LogServiceImp.getUserLogById() "+e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    
}
