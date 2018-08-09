/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Hadrdness;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class HardnessServiceImp implements HardnessService{

    @Override
    public List<Hadrdness> getAllHardness() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Hadrdness> hadrdnessList = session.createCriteria(Hadrdness.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return hadrdnessList;
        } catch (Exception e) {
            System.out.println("com.service.HardnessServiceImp.getAllHardness() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }
    
}
