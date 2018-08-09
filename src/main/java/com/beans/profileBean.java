/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Logs;
import com.service.LogServiceImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class profileBean extends BaseBean {
    private String password, newPassword,reNewPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
    

    public List<Logs> getLog() {
        LogServiceImp logServiceImp = new LogServiceImp();
        return logServiceImp.getUserLogById(getUserID());
    }
    
    public void changPassword(){
        
    }

}
