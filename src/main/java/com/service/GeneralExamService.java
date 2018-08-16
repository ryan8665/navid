/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.GeneralExam;
import com.entity.GeneralExamUser;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface GeneralExamService {
    
    public List<GeneralExam> getAllGeneralExam();
    
    public GeneralExam getGeneralExamDetaile(int id);
    
    public void saveGeneralExam(GeneralExam generalExam);
    
    public List<GeneralExamUser> getGeneralExamUser(int id);
}
