/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.GlobalStatus;
import com.entity.Redeem;
import com.entity.RedeemUser;
import com.entity.Transaction;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class FinanceServiceImp implements FinanceService{

    @Override
    public List<Transaction> getAllTransaction() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Transaction> transactionList = session.createCriteria(Transaction.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return transactionList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Transaction GetTransactionById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = (Transaction) session.get(Transaction.class, id);
            return transaction;
        } catch (Exception e) {
            System.out.println("com.service.TransactionServiceImp.GetTransactionById() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<Redeem> getAllRedeem() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Redeem> redeemList = session.createCriteria(Redeem.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return redeemList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Redeem geTredeemById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Redeem redeem = (Redeem) session.get(Redeem.class, id);
            return redeem;
        } catch (Exception e) {
            System.out.println("com.service.TransactionServiceImp.geTredeemById() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<RedeemUser> getAllRedeemUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<RedeemUser> redeemUserList = session.createCriteria(RedeemUser.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return redeemUserList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public RedeemUser getRedeemUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            RedeemUser redeemUser = (RedeemUser) session.get(RedeemUser.class, id);
            return redeemUser;
        } catch (Exception e) {
            System.out.println("com.service.TransactionServiceImp.getRedeemUserById() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<RedeemUser> getRedeemUserByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<RedeemUser> RedeemUserList = session.createCriteria(RedeemUser.class)
                    .add(Restrictions.eq("userId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return RedeemUserList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void changeRedeenStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Redeem on = (Redeem) session.get(Redeem.class, id);

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
    public void saveRedeem(Redeem redeem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(redeem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Transaction> getAllTransactionByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Transaction> transactionList = session.createCriteria(Transaction.class)
                    .add(Restrictions.eq("userId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return transactionList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
