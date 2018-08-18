/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Rule;
import com.entity.User;
import com.entity.UserRule;
import com.entity.UserType;
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
public class AuthorityServiceImp implements AuthorityService{

    @Override
    public List<Rule> getAllAuthority() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Rule> ruleList = session.createCriteria(Rule.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return ruleList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<UserRule> getUserAuthority(int user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<UserRule> userRuleList = session.createCriteria(UserRule.class)
                    .add(Restrictions.eq("userTypeId.id", user))
                    .addOrder(Order.desc("id"))
                    .list();
            return userRuleList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveUserAuthority(List<UserRule> rule,int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("DELETE FROM UserRule AS u WHERE u.userTypeId = " + id);
        session.beginTransaction();
        query.executeUpdate();
        for (UserRule userRule : rule) {
            session.save(userRule);
            session.flush();
            session.clear();
        }
        session.getTransaction().commit();
        session.close();
    }
    
}
