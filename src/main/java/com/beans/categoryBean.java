/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Category;
import com.service.CategoryService;
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
        
        private String catName,catDescription;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }
        
        
        
    public List<Category> getAllcategory(){
        CategoryService categoryServiceImp = new CategoryServiceImp();
        return categoryServiceImp.getAllCategory();
    }
    
    public List<Category> getAllcategorySorted() {
        CategoryService categoryServiceImp = new CategoryServiceImp();
        return categoryServiceImp.getAllCategorySorted();
    }
    
    public Category getCategoryDetaile() {
        CategoryService categoryServiceImp = new CategoryServiceImp();
        return categoryServiceImp.getCategoryDetaile(id);
    }
    
    public void saveCategory(){
        CategoryService categoryServiceImp = new CategoryServiceImp();
        Category oc = new Category();
        oc.setDescription(catDescription);
        oc.setName(catName);
        categoryServiceImp.saveCategory(oc);
        info("ثبت شد.");
        
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Category) event.getObject()).getId();
        CategoryService categoryServiceImp = new CategoryServiceImp();
        Category category =categoryServiceImp.getCategoryDetaile(id);

    }
    
}
