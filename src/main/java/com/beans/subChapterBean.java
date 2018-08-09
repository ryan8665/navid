/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.SubChapter;
import com.service.SubChapterServiceImp;
import java.util.List;

/**
 *
 * @author ryan
 */
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

}
