/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.GlobalStatus;
import com.entity.Package;
import com.entity.PackageUser;
import com.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class PackageServiceImp implements PackageService{

    @Override
    public List<Package> getAllPackage() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Package> PackageList = session.createCriteria(Package.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return PackageList;
        } catch (Exception e) {
            System.out.println("com.service.PackageServiceImp.getAllPackage() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<Package> getAllPakageByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Package> PackageList = session.createCriteria(Package.class)
                    .add(Restrictions.eq("userId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return PackageList;
        } catch (Exception e) {
            System.out.println("com.service.PackageServiceImp.getAllPakageByUserId() " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public Package getPackage(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            Package packag = (Package) session.get(Package.class, id);
            return packag;
        } catch (Exception e) {
            System.out.println("com.service.getAllPakageByUserId.getPackage(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void savePackage(Package packag) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(packag);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changePackageStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Package on = (Package) session.get(Package.class, id);

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
    public List<PackageUser> getUserFromPackage(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<PackageUser> packageUserList = session.createCriteria(PackageUser.class)
                    .add(Restrictions.eq("packageId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return packageUserList;
        } catch (Exception e) {
            System.out.println("com.service.PackageServiceImp.getUserFromPackage(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }
    
}
