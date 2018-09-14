/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.UserFav;
import java.util.List;


/**
 *
 * @author ryan
 */
public interface UserFavo {
    
    public List<UserFav> retriveAllUsersByUserId(int id);
    
    public void addUser(UserFav userFav);
    
    public void removeUser(int id);
    
    public UserFav geUserById(int id);
    
}
