/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Course;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface CourseService {
    
    public List<Course> getAllCourse();
    
    public Course getCourseDetaile(int id);

    public void saveCourse(Course course);
    
    int saveCourseRetriveID(Course course);
    
}
