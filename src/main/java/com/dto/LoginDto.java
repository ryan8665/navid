/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

import java.util.Date;

/**
 *
 * @author ryan
 */
public class LoginDto {
    private String name,family,phone,address,type;
    private boolean Login;
    private int id,userType;
    private Date LastLogin;

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date LastLogin) {
        this.LastLogin = LastLogin;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
    
    public boolean getLogin() {
        return Login;
    }

    public void setLogin(boolean Login) {
        this.Login = Login;
    }
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
    
    
}
