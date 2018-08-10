/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

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

    public List<Lesson> getAllLesson() {
        LessonService LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getAllLesson();
    }

    public Lesson getLessonDetaile() {
        LessonService LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getLessonDetaile(id);
    }
    
    public void saveLesson() {

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Lesson) event.getObject()).getId();
        LessonService LessonServiceImp = new LessonServiceImp();
        Lesson lesson = LessonServiceImp.getLessonDetaile(id);

    }

}
