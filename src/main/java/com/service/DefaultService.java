/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.List;
import com.entity.HardnessDefaults;

/**
 *
 * @author ryan
 */
public interface DefaultService {
    
    public List<HardnessDefaults> retriveAllDefaults();
    
    public HardnessDefaults getHardnessDefaults(int id);
    
    public void saveHardnessDefaults(HardnessDefaults hardnessDefaults);
    
}
