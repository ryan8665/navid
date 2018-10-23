/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.SubChapter;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface SubChapterService {
    
    public List<SubChapter> getAllSubChapter();

    public SubChapter getSubChapterDetaile(int id);

    public void saveSubChapter(SubChapter subChapter);
    
    int saveSubChapterRetriveID(SubChapter subChapter);
    
}
