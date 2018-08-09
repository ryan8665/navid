/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Course;
import com.service.CourseServiceImp;
import java.util.List;

/**
 *
 * @author ryan
 */
public class courseBean extends BaseBean {

    private boolean disable = true;
    private int id;

    public List<Course> getAllCourse() {
        CourseServiceImp CourseServiceImp = new CourseServiceImp();
        return CourseServiceImp.getAllCourse();
    }

    public Course getCourseDetaile() {
        CourseServiceImp CourseServiceImp = new CourseServiceImp();
        return CourseServiceImp.getCourseDetaile(id);
    }

}
