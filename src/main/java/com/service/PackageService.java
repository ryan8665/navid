/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Package;
import com.entity.PackageUser;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface PackageService {
    
    public List<Package> getAllPackage();
    
    public List<Package> getAllPakageByUserId(int id);
    
    public Package getPackage(int id);
    
    public void savePackage(Package packag);
    
    public void changePackageStatus(int id);
    
    public List<PackageUser> getUserFromPackage(int id);
    
}
