/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Message;
import com.entity.RoomUser;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface messageService {
    
    public List<Message> getAllInboxMessageByUserId(int id);
    
    public List<Message> getAllSentMessageByUserId(int id);
    
    public Message getMessageDetail(int id);
    
    public boolean saveMessage(Message message);
    
    public void updateMessageFlag(int id);
    
    public Long countUnreadMessage(int id);
    
    public void saveBatchMsg(List<RoomUser> users ,String msg ,String title,int sender);
}
