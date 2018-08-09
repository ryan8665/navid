/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loger;

import com.beans.main;
import com.beans.main;
import com.utility.HibernateUtil;
import com.entity.LogType;
import com.entity.Logs;

import com.entity.User;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author ryan
 */
public class log {

    public static void newLog(int logID) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Logs ol = new Logs();
        ol.setLogTypeId(new LogType(logID));
        ol.setUserId(new User(getUserID()));
        ol.setDate(new Date());
        session.beginTransaction();
        session.save(ol);
        session.getTransaction().commit();
        session.close();

    }
    public static void newLog(int logID, int user) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Logs ol = new Logs();
        ol.setLogTypeId(new LogType(user));
        ol.setUserId(new User(getUserID()));
        ol.setDate(new Date());
        session.beginTransaction();
        session.save(ol);
        session.getTransaction().commit();
        session.close();

    }

    public static int getUserID() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String contextPath = ((HttpServletRequest) request).getContextPath();
        main loginBean = (main) request.getSession().getAttribute("main");
        System.out.println("loginBean " +loginBean);
        return loginBean.getLoginDto().getId();
       
    }

}
