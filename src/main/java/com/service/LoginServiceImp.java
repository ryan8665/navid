/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dto.LoginDto;
import com.entity.User;
import com.entity.UserRule;
import com.utility.HibernateUtil;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class LoginServiceImp implements LoginService{

    @Override
    public LoginDto doLogin(String mobile,String password)  {
        LoginDto loginDto =  new LoginDto();
        boolean isLogin = false;
        int globalStatus = 0;
        String p = null, u = null;
        int t = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        session.clear();
        User user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("mobile", mobile))
                .add(Restrictions.eq("password", password))
                .uniqueResult();

        try {
            loginDto.setFamily(user.getFamily());
            loginDto.setId(user.getId());
            loginDto.setName(user.getName());
            loginDto.setPhone(user.getMobile());
            loginDto.setUserType(user.getUserTypeId().getId());
            loginDto.setType(user.getUserTypeId().getName());
            loginDto.setAddress(user.getAddress());
            try {
                loginDto.setLastLogin(user.getLastlogin());
            } catch (Exception e) {
                
            }
        
            
            
            u = user.getMobile();
            p = user.getPassword();
            globalStatus = user.getGlobalStatusId().getId();
            if (password.equals(p) || mobile.equals(u)) {
             
                isLogin = true;
            }else{
                isLogin = false;
            }

        } catch (Exception e) {
            isLogin = false;
        } finally {
            session.close();
            System.gc();
            loginDto.setLogin(isLogin);
            return loginDto;
        }

    }

    @Override
    public List<UserRule> getUserRule(int userID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<UserRule> userRule = session.createCriteria(UserRule.class)
                    .add(Restrictions.eq("userTypeId.id", userID))
                    .list();
                    
            return userRule;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void updateLastLoginById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User on = (User) session.get(User.class, id);
        on.setLastlogin(new Date());
        session.beginTransaction();
        session.update(on);
        session.getTransaction().commit();
        session.close();
    }
       
}
