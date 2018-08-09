/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Message;
import com.entity.User;
import com.service.UserServiceImp;
import com.service.messageServiceImp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class sentMessageBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private Date vDate;
    private String vReciver, Reciver;
    private String vTitle, title;
    private String vMessage, message;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getvDate() {
        return vDate;
    }

    public void setvDate(Date vDate) {
        this.vDate = vDate;
    }

    public String getvReciver() {
        return vReciver;
    }

    public void setvReciver(String vReciver) {
        this.vReciver = vReciver;
    }

    public String getReciver() {
        return Reciver;
    }

    public void setReciver(String Reciver) {
        this.Reciver = Reciver;
    }

    public String getvTitle() {
        return vTitle;
    }

    public void setvTitle(String vTitle) {
        this.vTitle = vTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getvMessage() {
        return vMessage;
    }

    public void setvMessage(String vMessage) {
        this.vMessage = vMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<Message> retriveAllSent() {
        messageServiceImp messageService = new messageServiceImp();
        return messageService.getAllSentMessageByUserId(getUserID());
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Message) event.getObject()).getId();
        messageServiceImp messageService = new messageServiceImp();
        Message message = messageService.getMessageDetail(id);
        try {
            vDate = message.getDate();
        } catch (Exception e) {
            vDate = null;
        }

        vReciver = message.getSender().getName() + " " + message.getSender().getFamily();
        vTitle = message.getTitle();
        vMessage = message.getMessage();

    }
    
    public void sendMessage(){
        Message om = new Message();
        om.setDate(new Date());
        om.setMessage(message);
        om.setMessageFlagId(0);
        om.setReciver(new User(Integer.parseInt(Reciver)));
        om.setSender(new User(getUserID()));
        om.setTitle(title);
        messageServiceImp messageService = new messageServiceImp();
        messageService.saveMessage(om);
    }
    
    public List<User> userLIst(){
        UserServiceImp ou = new UserServiceImp();
        return ou.getAllUser();
    }
    
}
