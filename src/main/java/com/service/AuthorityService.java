/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Rule;
import com.entity.UserRule;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface AuthorityService {
    
    public List<Rule> getAllAuthority();
    
    public List<UserRule> getUserAuthority(int type);
    
    public void saveUserAuthority(List<UserRule> rule,int id);
    
}
