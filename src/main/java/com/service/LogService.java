/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Logs;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface LogService {

    public List<Logs> getUserLogById(int UserId);
    
    public List<Logs> getUserLogByIdAndLogType(int UserId,int LogType);

}
