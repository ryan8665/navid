/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.News;
import com.entity.NewsCat;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface NewsService {
    public List<News> getNewsAll();
    
    public News getNewsById(int id);
    
    public List<NewsCat> getNewsCat();
    
    public boolean SaveNews(News news);
    
    public void changeNewsStatus(int id);
}
