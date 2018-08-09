/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.SubChapter;
import com.entity.UserType;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class UserTypeServiceImp implements UserTypeService{

    @Override
    public List<UserType> getAllUserTypes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<UserType> userType = session.createCriteria(UserType.class)
                    .addOrder(Order.asc("name"))
                    .list();
            return userType;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public UserType getUserTypeDetaile(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
