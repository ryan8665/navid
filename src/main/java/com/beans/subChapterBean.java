/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
import com.entity.SubChapter;
import com.service.SubChapterService;
import com.service.SubChapterServiceImp;
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
public class subChapterBean extends BaseBean {

    private boolean disable = true;
    private int id;
    private String name,description;
    private int chapterID,Sequence;

    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int Sequence) {
        this.Sequence = Sequence;
    }
    
    

    public int getChapterID() {
        return chapterID;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
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
    
    

    public List<SubChapter> getAllSubChapter() {
        SubChapterService subChapterServiceImp = new SubChapterServiceImp();
        return subChapterServiceImp.getAllSubChapter();
    }

    public SubChapter getSubChapterDetaile() {
        SubChapterService subChapterServiceImp = new SubChapterServiceImp();
        return subChapterServiceImp.getSubChapterDetaile(id);
    }
    
    public void saveSubChapter() {
        SubChapterService subChapterServiceImp = new SubChapterServiceImp();
        SubChapter os = new SubChapter();
        os.setChapterId(new Chapter(chapterID));
        os.setDescription(description);
        os.setName(name);
        os.setSequence(Sequence);
        subChapterServiceImp.saveSubChapter(os);
        info("ثبت شد.");

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((SubChapter) event.getObject()).getId();
        SubChapterService subChapterServiceImp = new SubChapterServiceImp();
        SubChapter subChapter = subChapterServiceImp.getSubChapterDetaile(id);

    }

}
