/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dto.LoginDto;
import com.dto.UserRuleDto;
import com.entity.UserRule;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface LoginService {
    public LoginDto doLogin(String mobile, String password) ;
    
    public List<UserRule> getUserRule(int userID);
    
    public void updateLastLoginById(int id);
    
}
