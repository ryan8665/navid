/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.GlobalStatus;
import com.entity.Media;
import com.entity.MediaType;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class LibraryServiceImp implements LibraryService{

    @Override
    public List<Media> getAllLibrary() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Media> mediaList = session.createCriteria(Media.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return mediaList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Media> getUserLibrary(int user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Media> mediaList = session.createCriteria(Media.class)
                    .add(Restrictions.eq("userId.id", user))
                    .addOrder(Order.desc("id"))
                    .list();
            return mediaList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Media> getLibraryByChapter(int chapter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Media> mediaList = session.createCriteria(Media.class)
                    .add(Restrictions.eq("chapterId.id", chapter))
                    .addOrder(Order.desc("id"))
                    .list();
            return mediaList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Media getLibraryById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            Media media = (Media) session.get(Media.class, id);
            return media;
        } catch (Exception e) {
            System.out.println("com.service.MediaServiceImp.getLibraryById() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveMedia(Media media) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(media);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changeLibraryStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Media on = (Media) session.get(Media.class, id);

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
    public List<MediaType> getMediaType() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<MediaType> mediaTypeList = session.createCriteria(MediaType.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return mediaTypeList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
