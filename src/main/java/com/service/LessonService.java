/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Lesson;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface LessonService {
    
    public List<Lesson> getAllLesson();
    
    public Lesson getLessonDetaile(int id);

    public void saveLesson(Lesson lesson);
    
     int saveLessonRetrive(Lesson lesson);
    
}
