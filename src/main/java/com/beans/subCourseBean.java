/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Lesson;
import com.service.LessonServiceImp;
import java.text.ParseException;
import java.util.List;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
public class subCourseBean extends BaseBean {

    private boolean disable = true;
    private int id;

    public List<Lesson> getAllLesson() {
        LessonServiceImp LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getAllLesson();
    }

    public Lesson getLessonDetaile() {
        LessonServiceImp LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getLessonDetaile(id);
    }
    
    public void saveLesson() {

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Lesson) event.getObject()).getId();
        LessonServiceImp LessonServiceImp = new LessonServiceImp();
        Lesson lesson = LessonServiceImp.getLessonDetaile(id);

    }

}
