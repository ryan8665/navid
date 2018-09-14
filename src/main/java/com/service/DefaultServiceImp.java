/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.HardnessDefaults;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class DefaultServiceImp implements DefaultService{

    @Override
    public List<HardnessDefaults> retriveAllDefaults() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<HardnessDefaults> hardnessDefaultsList = session.createCriteria(HardnessDefaults.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return hardnessDefaultsList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public HardnessDefaults getHardnessDefaults(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            HardnessDefaults hardnessDefaults = (HardnessDefaults) session.get(HardnessDefaults.class, id);
            return hardnessDefaults;
        } catch (Exception e) {
            System.out.println("com.service.DefaultServiceImp.getHardnessDefaults " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveHardnessDefaults(HardnessDefaults hardnessDefaults) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(hardnessDefaults);
        session.getTransaction().commit();
        session.close();
    }
    
}
