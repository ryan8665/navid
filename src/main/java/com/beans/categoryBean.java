/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Category;
import com.service.CategoryServiceImp;
import java.text.ParseException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
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
    
    public void saveCategory(){
        
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Category) event.getObject()).getId();
        CategoryServiceImp categoryServiceImp = new CategoryServiceImp();
        Category category =categoryServiceImp.getCategoryDetaile(id);

    }
    
}
