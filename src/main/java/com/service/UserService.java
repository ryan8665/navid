/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.User;
import java.util.List;

/**
 *
 * @author ryanó
 */
public interface UserService {

    public List<User> getAllUser();

    public List<User> getAllUserNoAdmin();

    public List<User> getAllStudent();
    
    public List<Object[]> cuntUserGroupByUser();
    
    public User getUserById(int id);
    
    public void changeUserStatus(int id);
    
    public void saveUser(User user);
    
    public List<User> getAllUserExptStudent();
    
    public boolean chackUserisExist(String mobile);
    
    public void changePassword(int user,String password);


}
