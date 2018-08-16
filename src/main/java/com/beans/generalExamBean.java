/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
import com.entity.GeneralExam;
import com.entity.GeneralExamUser;
import com.service.ChapterService;
import com.service.ChapterServiceImp;
import com.service.GeneralExamService;
import com.service.GeneralExamServiceImp;
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
public class generalExamBean extends BaseBean{
    private boolean disable = true;
    private int id;

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
    
    
    public List<GeneralExam> getAllGeneralExam(){
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        return generalExamService.getAllGeneralExam();          
    }
    
    public List<GeneralExamUser> getAllGeneralExamUserByID(){
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        return generalExamService.getGeneralExamUser(id);
    }
    
    public void saveGeneralExam(){
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        GeneralExam og = new GeneralExam();
        generalExamService.saveGeneralExam(og);
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((GeneralExam) event.getObject()).getId();
        GeneralExamService generalExamService = new GeneralExamServiceImp();
        GeneralExam generalExam = generalExamService.getGeneralExamDetaile(id);

    }
    
}
