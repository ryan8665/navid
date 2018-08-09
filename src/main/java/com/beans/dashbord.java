/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Logs;
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
public class dashbord {
    public List<Logs> test(){
        LogServiceImp logService = new LogServiceImp();
        return logService.getUserLogById(1);
    }
    
}
