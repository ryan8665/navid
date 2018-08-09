/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Category;
import com.service.CategoryServiceImp;
import java.util.List;

/**
 *
 * @author ryan
 */
public class categoryBean extends BaseBean{
        private boolean disable =true;
        private int id;
        
    public List<Category> getAllcategory(){
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        return categoryServiceImp.getAllCategory();
    }
    
    public Category getCategoryDetaile() {
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        return categoryServiceImp.getCategoryDetaile(id);
    }
    
}
