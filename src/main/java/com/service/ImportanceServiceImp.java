/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Importance;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class ImportanceServiceImp implements ImportanceService {

    @Override
    public List<Importance> getAllImportance() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Importance> importance = session.createCriteria(Importance.class)
                    .addOrder(Order.asc("name"))
                    .list();
            return importance;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

}
