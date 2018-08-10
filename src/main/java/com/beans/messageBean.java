/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Message;
import com.entity.Redeem;
import com.service.FinanceServiceImp;
import com.service.messageService;
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
public class messageBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private Date vDate;
    private String vSender;
    private String vMaxUser,title;
    private String vMessage,message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getvDate() {
        return vDate;
    }

    public void setvDate(Date vDate) {
        this.vDate = vDate;
    }

    public String getvSender() {
        return vSender;
    }

    public void setvSender(String vSender) {
        this.vSender = vSender;
    }

    public String getvMaxUser() {
        return vMaxUser;
    }

    public void setvMaxUser(String vMaxUser) {
        this.vMaxUser = vMaxUser;
    }

    public String getvMessage() {
        return vMessage;
    }

    public void setvMessage(String vMessage) {
        this.vMessage = vMessage;
    }

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
    
    
    public List<Message> retriveAllInbox(){
        messageService messageService = new messageServiceImp();
        return messageService.getAllInboxMessageByUserId(getUserID());
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Message) event.getObject()).getId();
        messageService messageService = new messageServiceImp();
        Message message = messageService.getMessageDetail(id);
        try {
            vDate = message.getDate();
        } catch (Exception e) {
            vDate = null;
        }

        vSender = message.getSender().getName() + " " + message.getSender().getFamily();
        vMaxUser = message.getTitle();
        vMessage = message.getMessage();
        messageService.updateMessageFlag(id);

    }
}
