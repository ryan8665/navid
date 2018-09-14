/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
import com.entity.Lesson;
import com.service.ChapterService;
import com.service.ChapterServiceImp;
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
public class chapterBean extends BaseBean {

    private boolean disable = true;
    private int id;
    private String chapterName,chapterDescription;
    private int subCourseID;

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

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDescription() {
        return chapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }


    public int getSubCourseID() {
        return subCourseID;
    }

    public void setSubCourseID(int subCourseID) {
        this.subCourseID = subCourseID;
    }
    
    

    public List<Chapter> getAllChapter() {
        ChapterService chapterServiceImp = new ChapterServiceImp();
        return chapterServiceImp.getAllChapter();
    }

    public Chapter getChapterDetaile() {
        ChapterService chapterServiceImp = new ChapterServiceImp();
        return chapterServiceImp.getChapterDetaile(id);
    }

    public void saveChapter() {
        ChapterService chapterServiceImp = new ChapterServiceImp();
        Chapter oc = new Chapter();
        oc.setDescription(chapterName);
        oc.setLessonId(new Lesson(subCourseID));
        oc.setName(chapterName);
        chapterServiceImp.saveChapter(oc);
        info("ثبت شد.");
    }

    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Chapter) event.getObject()).getId();
        ChapterService chapterServiceImp = new ChapterServiceImp();
        Chapter chapter = chapterServiceImp.getChapterDetaile(id);

    }

}
