/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Category;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author ryan
 */
public class CategoryServiceImp implements CategoryService{

    @Override
    public List<Category> getAllCategory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Category> categoryList = session.createCriteria(Category.class)
                    .addOrder(Order.asc("name"))
                    .list();
            return categoryList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Category getCategoryDetaile(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Category category = (Category) session.get(Category.class, id);
            return category;
        } catch (Exception e) {
            System.out.println("com.service.CategoryServiceImp.getCategoryDetaile(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void saveCategory(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Category> getAllCategorySorted() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Category> categoryList = session.createCriteria(Category.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return categoryList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int saveCategoryRetriveId(Category category) {
        int id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(category);
        id = category.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

}
