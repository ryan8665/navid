/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.UserType;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface UserTypeService {

    public List<UserType> getAllUserTypes();
    
    public UserType getUserTypeDetaile(int id);

}
