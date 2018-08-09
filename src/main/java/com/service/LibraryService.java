/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Media;
import com.entity.MediaType;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface LibraryService {
    public List<Media> getAllLibrary();
    
    public List<Media> getUserLibrary(int user);
    
    public List<Media> getLibraryByChapter(int chapter);
    
    public Media getLibraryById(int id);
    
    public void saveMedia(Media media);
    
    public void changeLibraryStatus(int id);
    
    public List<MediaType> getMediaType();
    
    
}
