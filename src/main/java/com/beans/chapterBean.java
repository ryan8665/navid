/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
import com.service.ChapterServiceImp;
import java.text.ParseException;
import java.util.List;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
public class chapterBean extends BaseBean {

    private boolean disable = true;
    private int id;

    public List<Chapter> getAllChapter() {
        ChapterServiceImp chapterServiceImp = new ChapterServiceImp();
        return chapterServiceImp.getAllChapter();
    }

    public Chapter getChapterDetaile() {
        ChapterServiceImp chapterServiceImp = new ChapterServiceImp();
        return chapterServiceImp.getChapterDetaile(id);
    }

    public void saveChapter() {

    }

    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Chapter) event.getObject()).getId();
        ChapterServiceImp chapterServiceImp = new ChapterServiceImp();
        Chapter chapter = chapterServiceImp.getChapterDetaile(id);

    }

}
