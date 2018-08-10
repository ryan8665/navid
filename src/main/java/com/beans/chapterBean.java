/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
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

    public List<Chapter> getAllChapter() {
        ChapterService chapterServiceImp = new ChapterServiceImp();
        return chapterServiceImp.getAllChapter();
    }

    public Chapter getChapterDetaile() {
        ChapterService chapterServiceImp = new ChapterServiceImp();
        return chapterServiceImp.getChapterDetaile(id);
    }

    public void saveChapter() {

    }

    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Chapter) event.getObject()).getId();
        ChapterService chapterServiceImp = new ChapterServiceImp();
        Chapter chapter = chapterServiceImp.getChapterDetaile(id);

    }

}
