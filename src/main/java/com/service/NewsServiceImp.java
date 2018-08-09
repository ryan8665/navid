/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.GlobalStatus;
import com.entity.Logs;
import com.entity.News;
import com.entity.NewsCat;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class NewsServiceImp implements NewsService{

    @Override
    public List<News> getNewsAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<News> news = session.createCriteria(News.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return news;
        } catch (Exception e) {
            System.out.println("com.service.NewsServiceImp.getNewsAll() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }
    
    @Override
    public News getNewsById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            
            News news = (News) session.get(News.class, id);
            return news;
        } catch (Exception e) {
            System.out.println("com.service.NewsServiceImp.getNewsAll() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<NewsCat> getNewsCat() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<NewsCat> NewsCatList = session.createCriteria(NewsCat.class)
                    .addOrder(Order.desc("name"))
                    .list();
            return NewsCatList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean SaveNews(News news) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(news);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public void changeNewsStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        News on = (News) session.get(News.class, id);

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
    
}
