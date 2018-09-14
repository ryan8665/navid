/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Course;
import com.entity.Lesson;
import com.service.LessonService;
import com.service.LessonServiceImp;
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
public class subCourseBean extends BaseBean {

    private boolean disable = true;
    private int id;
    private String subCourseName,subCourseDescription;
    private int CourseId;

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

    public String getSubCourseName() {
        return subCourseName;
    }

    public void setSubCourseName(String subCourseName) {
        this.subCourseName = subCourseName;
    }

    public String getSubCourseDescription() {
        return subCourseDescription;
    }

    public void setSubCourseDescription(String subCourseDescription) {
        this.subCourseDescription = subCourseDescription;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }
    
    

    public List<Lesson> getAllLesson() {
        LessonService LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getAllLesson();
    }

    public Lesson getLessonDetaile() {
        LessonService LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getLessonDetaile(id);
    }
    
    public void saveLesson() {
        LessonService LessonService = new LessonServiceImp();
        Lesson ol = new Lesson();
        ol.setCourseId(new Course(CourseId));
        ol.setDescription(subCourseDescription);
        ol.setName(subCourseName);
        LessonService.saveLesson(ol);
        info("ثبت شد.");

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Lesson) event.getObject()).getId();
        LessonService LessonServiceImp = new LessonServiceImp();
        Lesson lesson = LessonServiceImp.getLessonDetaile(id);

    }

}
