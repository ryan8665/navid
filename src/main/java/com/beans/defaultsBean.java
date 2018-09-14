/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.HardnessDefaults;
import com.service.DefaultServiceImp;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class defaultsBean extends BaseBean{
    private boolean disable = true;
    private int id;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    public List<HardnessDefaults> getAllDefaults(){
        DefaultServiceImp defaultServiceImp = new DefaultServiceImp();
        return defaultServiceImp.retriveAllDefaults();
    }
    
    
}
