/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Category;
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
    private String courseName,courseDescription;
    private  int groupid;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }
    
    

    public List<Course> getAllCourse() {
        CourseService CourseServiceImp = new CourseServiceImp();
        return CourseServiceImp.getAllCourse();
    }

    public Course getCourseDetaile() {
        CourseService CourseServiceImp = new CourseServiceImp();
        return CourseServiceImp.getCourseDetaile(id);
    }
    
    public void saveCourse() {
        CourseService courseServiceImp = new CourseServiceImp();
        Course oc = new Course();
        oc.setCategoryId(new Category(groupid));
        oc.setDescription(courseDescription);
        oc.setName(courseName);
        courseServiceImp.saveCourse(oc);

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Course) event.getObject()).getId();
        CourseService courseServiceImp = new CourseServiceImp();
        Course course = courseServiceImp.getCourseDetaile(id);

    }

}
