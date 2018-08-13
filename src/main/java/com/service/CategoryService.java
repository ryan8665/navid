/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Category;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface CategoryService {
    public List<Category> getAllCategory();
    
    public List<Category> getAllCategorySorted();
    
    public Category getCategoryDetaile(int id);
    
    public void saveCategory(Category category);
    
 
    
}
