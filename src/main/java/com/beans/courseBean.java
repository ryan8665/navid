/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Course;
import com.service.CourseService;
import com.service.CourseServiceImp;
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
public class courseBean extends BaseBean {

    private boolean disable = true;
    private int id;

    public List<Course> getAllCourse() {
        CourseService CourseServiceImp = new CourseServiceImp();
        return CourseServiceImp.getAllCourse();
    }

    public Course getCourseDetaile() {
        CourseService CourseServiceImp = new CourseServiceImp();
        return CourseServiceImp.getCourseDetaile(id);
    }
    
    public void saveCourse() {

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Course) event.getObject()).getId();
        CourseService courseServiceImp = new CourseServiceImp();
        Course course = courseServiceImp.getCourseDetaile(id);

    }

}
