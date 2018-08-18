/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Message;
import com.entity.RoomUser;
import com.entity.User;
import com.entity.UserRule;
import com.utility.HibernateUtil;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ryan
 */
public class messageServiceImp implements messageService {

    @Override
    public List<Message> getAllInboxMessageByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Message> messageList = session.createCriteria(Message.class)
                    .add(Restrictions.eq("sender.id", id))
                    .addOrder(Order.asc("messageFlagId"))
                    .addOrder(Order.desc("id"))
                    .list();
            return messageList;
        } catch (Exception e) {
            System.out.println("com.service.messageServiceImp.getAllInboxMessageByUserId(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List<Message> getAllSentMessageByUserId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Message> messageList = session.createCriteria(Message.class)
                    .add(Restrictions.eq("reciver.id", id))
                    .addOrder(Order.desc("id"))
                    .list();
            return messageList;
        } catch (Exception e) {
            System.out.println("com.service.messageServiceImp.getAllSentMessageByUserId(int id) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public Message getMessageDetail(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            Message message = (Message) session.get(Message.class, id);
            return message;
        } catch (Exception e) {
            System.out.println("com.service.messageServiceImp.getMessageDetail(int id)) " + e.toString());
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public boolean saveMessage(Message message) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public void updateMessageFlag(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Message on = (Message) session.get(Message.class, id);
        on.setMessageFlagId(1);

        session.beginTransaction();
        session.update(on);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Long countUnreadMessage(int id)  {
        Session session = HibernateUtil.getSessionFactory().openSession();
        BigInteger temp =  (BigInteger) session.createSQLQuery("SELECT count(`id`) FROM `message` WHERE `message_flag_id` = 0 and `reciver` = " + id).uniqueResult();
        return temp.longValue();
    }

    @Override
    public void saveBatchMsg(List<RoomUser> users, String message , String title , int sender) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Message om;
        for (RoomUser user : users) {
            om = new Message();
            om.setDate(new Date());
            om.setMessage(message);
            om.setMessageFlagId(0);
            om.setReciver(user.getUserId());
            om.setSender(new User(sender));
            om.setTitle(title);
            session.save(om);
            session.flush();
            session.clear();
        }
        session.getTransaction().commit();
        session.close();
    }

}
