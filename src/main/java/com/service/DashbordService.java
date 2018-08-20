/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

/**
 *
 * @author ryan
 */
public interface DashbordService {
    public int countVisits();
    
    public int countQuestion();
    
    public int countUsers();
    
    public int countTransaction();
    
    public int countPackage();
    
    public int getListofSell(int day);
    
    public int getListofVisit(int day);
    
    public int getListofUsers(int day);
}
