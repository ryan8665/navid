/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enums;

/**
 *
 * @author ryan
 */
public enum messageStatus {
    UNREAD(1,"new"),
    READ(2,"Readed");
    
    private int id;
    private String status;

    private messageStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    
    
    
    
}
