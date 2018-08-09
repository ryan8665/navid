/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.SubChapter;
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

    public List<SubChapter> getAllSubChapter() {
        SubChapterServiceImp subChapterServiceImp = new SubChapterServiceImp();
        return subChapterServiceImp.getAllSubChapter();
    }

    public SubChapter getSubChapterDetaile() {
        SubChapterServiceImp subChapterServiceImp = new SubChapterServiceImp();
        return subChapterServiceImp.getSubChapterDetaile(id);
    }
    
    public void saveSubChapter() {

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((SubChapter) event.getObject()).getId();
        SubChapterServiceImp subChapterServiceImp = new SubChapterServiceImp();
        SubChapter subChapter = subChapterServiceImp.getSubChapterDetaile(id);

    }

}
