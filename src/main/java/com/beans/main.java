/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.dto.LoginDto;
import com.entity.UserRule;
import com.service.LoginService;
import com.service.LoginServiceImp;
import com.service.messageService;
import com.service.messageServiceImp;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ryan
 */
@ManagedBean
@SessionScoped
public class main {

    private LoginDto loginDto;
    private String mobile, password ;
    private List<UserRule> userRule;
    boolean isLOgin;
    private long messageCount = 0 ;

    public long getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(long messageCount) {
        this.messageCount = messageCount;
    }
    

    public LoginDto getLoginDto() {
        return loginDto;
    }

    public void setLoginDto(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

    public boolean isIsLOgin() {
        return isLOgin;
    }

    public void setIsLOgin(boolean isLOgin) {
        this.isLOgin = isLOgin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public main() {
        loginDto = new LoginDto();
        userRule = new ArrayList<>();
    }


    public void doLogin() throws IOException {
        LoginService ol = new LoginServiceImp();

        loginDto = ol.doLogin(mobile, password);
        isLOgin = loginDto.getLogin();
        
        if(isLOgin){
            userRule = ol.getUserRule(loginDto.getUserType());
            ol.updateLastLoginById(loginDto.getUserType());
            com.loger.log.newLog(1);
            com.utility.SMS.sendWelcome(mobile, loginDto.getName()+" "+loginDto.getFamily());
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin/index.xhtml");
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "نام کاربری  یا پسورد اشتباه می باشد", "نام کاربری  یا پسورد اشتباه می باشد"));
        }

       

    }

    public void resetPassword() {
    }
    
    public void unreadMessageCount(){
        messageService s = new messageServiceImp();
        messageCount = s.countUnreadMessage(loginDto.getId());
    }

}
