/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Message;
import com.entity.UserType;
import com.service.UserTypeService;
import com.service.UserTypeServiceImp;
import com.service.messageServiceImp;
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
public class settingBean {

    private boolean disable = true;
    private int id;
    private String vName;
    private String vDescription;

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

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvDescription() {
        return vDescription;
    }

    public void setvDescription(String vDescription) {
        this.vDescription = vDescription;
    }
    
    

    public List<UserType> getUserType() {
        UserTypeService userTypeServiceImp = new UserTypeServiceImp();
        return userTypeServiceImp.getAllUserTypes();
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((UserType) event.getObject()).getId();
        UserTypeServiceImp userTypeServiceImp = new UserTypeServiceImp();
        UserType userType = userTypeServiceImp.getUserTypeDetaile(id);

        vName = userType.getName();
        vDescription = userType.getDescription();


    }

}
