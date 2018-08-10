/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Logs;
import com.service.LogService;
import com.service.LogServiceImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class logsBean extends BaseBean{
    public List<Logs> log() {
        LogService logService = new LogServiceImp();
        return logService.getUserLogById(getUserID());
    }
    
}
