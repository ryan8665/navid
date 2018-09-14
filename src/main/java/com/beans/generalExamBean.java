/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
import com.entity.GeneralExam;
import com.entity.GeneralExamUser;
import com.entity.Lesson;
import com.service.ChapterService;
import com.service.ChapterServiceImp;
import com.service.GeneralExamService;
import com.service.GeneralExamServiceImp;
import com.service.LessonService;
import com.service.LessonServiceImp;
import java.text.ParseException;
import java.util.Date;
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
public class generalExamBean extends BaseBean {

    private boolean disable = true;
    private int id;
    private String name ,vname,vdescription, description, course;
    private Date dueDate, ExpireDate;

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVdescription() {
        return vdescription;
    }

    public void setVdescription(String vdescription) {
        this.vdescription = vdescription;
    }

    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

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

    public List<GeneralExam> getAllGeneralExam() {
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        return generalExamService.getAllGeneralExam();
    }

    public List<GeneralExamUser> getAllGeneralExamUserByID() {
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        return generalExamService.getGeneralExamUser(id);
    }

    public void saveGeneralExam() {
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        GeneralExam og = new GeneralExam();
        og.setCreationDate(new Date());
        og.setDueDate(dueDate);
        og.setDescription(description);
        og.setExpireDate(ExpireDate);
        og.setName(name);
        og.setLessonId(new Lesson(Integer.parseInt(course)));
        generalExamService.saveGeneralExam(og);
        info("ثبت شد.");
    }

    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((GeneralExam) event.getObject()).getId();
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        GeneralExam generalExam = generalExamService.getGeneralExamDetaile(id);
        vname = generalExam.getName();
        vdescription = generalExam.getDescription();

    }

    public List<Lesson> getAllLesson() {
        LessonService LessonServiceImp = new LessonServiceImp();
        return LessonServiceImp.getAllLesson();
    }

    public List<GeneralExamUser> getAllUser() {
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        return generalExamService.getGeneralExamUser(id);
    }

}
