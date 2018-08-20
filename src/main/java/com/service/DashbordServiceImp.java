/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.utility.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ryan
 */
public class DashbordServiceImp implements DashbordService{

    @Override
    public int countVisits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 1 and DATE(`date`) = DATE(NOW())").uniqueResult();
        try {
            int res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int countQuestion() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 601 and DATE(`date`) = DATE(NOW())").uniqueResult();
        try {
            int res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int countUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 101 and DATE(`date`) = DATE(NOW())").uniqueResult();
        try {
            int res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int countTransaction() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 501 and DATE(`date`) = DATE(NOW())").uniqueResult();
        try {
            int res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int countPackage() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 201 and DATE(`date`) = DATE(NOW())").uniqueResult();
        try {
            int res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int getListofSell(int day) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 502  and DATE(`date`) = DATE(NOW())-" + day ).uniqueResult();
        int res = 0;
        try {
            res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int getListofVisit(int day) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 1  and DATE(`date`) = DATE(NOW())-" + day).uniqueResult();
        int res = 0;
        try {
            res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int getListofUsers(int day) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Object ob = session.createSQLQuery("SELECT count(`id`) FROM `logs` WHERE `log_type_id` = 101  and DATE(`date`) = DATE(NOW())-" + day).uniqueResult();
        int res = 0;
        try {
            res = Integer.parseInt(ob.toString());
            return res;
        } catch (Exception e) {
            return 0;
        } finally {
            session.close();
        }
    }
    
    
}
