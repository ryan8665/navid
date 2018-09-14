/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Logs;
import com.entity.UserFav;
import com.service.LogService;
import com.service.LogServiceImp;
import com.service.UserFavImp;
import java.text.ParseException;
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
public class userFavBean extends BaseBean{
    private boolean disable = true;
    private int id;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((UserFav) event.getObject()).getUserId1().getId();
        System.out.println("------------------------- userFave");
//        UserFavImp userFavImp = new UserFavImp();
//        UserFav userFav = userFavImp.geUserById(id);

    }
    
    public List<UserFav> allUser(){
        UserFavImp userFavImp = new UserFavImp();
        return userFavImp.retriveAllUsersByUserId(getUserID());
    }
    
    public List<Logs> getAllUserLog() {
        LogService logService = new LogServiceImp();
        return logService.getUserLogById(id);
    }
    
}
