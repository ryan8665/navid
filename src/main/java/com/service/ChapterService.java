/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Chapter;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface ChapterService {
    
    public List<Chapter> getAllChapter();

    public Chapter getChapterDetaile(int id);

    public void saveChapter(Chapter chapter);
    
     int saveChapterRetriveID(Chapter chapter);
    
}
