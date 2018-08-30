/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Room;
import com.entity.RoomUser;
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
public class RoomServiceImp implements RoomService{

    @Override
    public List<Room> getAllRooms() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Room> rooms = session.createCriteria(Room.class)
                    .addOrder(Order.desc("id"))
                    .list();
            return rooms;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Room> getAllRoomByPackage(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Room> rooms = session.createCriteria(Room.class)
                    .add(Restrictions.eq("packageId.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return rooms;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void saveRoom(Room room) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(room);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteRoom(Room room) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        session.clear();
        Query query = session.createQuery("DELETE FROM RoomUser AS r WHERE r.roomId = " + room.getId());

     
        session.beginTransaction();
        query.executeUpdate();
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changeRoomStatus(int room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room getRoomDetaile(int room) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Room r = (Room) session.get(Room.class, room);
            return r;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public void addUserToRoom(RoomUser roomUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(roomUser);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserFromRoom(RoomUser roomUser) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(roomUser);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<RoomUser> getUsersOfRoom(int room) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<RoomUser> roomUser = session.createCriteria(RoomUser.class)
                    .add(Restrictions.eq("roomId.id", room))
                    .addOrder(Order.desc("id"))
                    .list();
            return roomUser;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Room> getAllRoomByUsers(int id , int packageID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Room> rooms = session.createQuery("SELECT E FROM Room AS E WHERE E.packageId.userId.id = "+id+" and E.packageId.id ="+ packageID)
                    .list();
            return rooms;
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        } finally {
            session.close();
        }
    }
    
    
    
}
