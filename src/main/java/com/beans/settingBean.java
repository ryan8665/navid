/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Message;
import com.entity.Rule;
import com.entity.UserRule;
import com.entity.UserType;
import com.service.AuthorityService;
import com.service.AuthorityServiceImp;
import com.service.UserTypeService;
import com.service.UserTypeServiceImp;
import com.service.messageServiceImp;
import java.text.ParseException;
import java.util.ArrayList;
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
public class settingBean extends BaseBean{

    private boolean disable = true;
    private int id;
    private String vName;
    private String vDescription;
    private List<UserRule> selectedRule;
    private List<String> userRule;

    public settingBean() {
        selectedRule = new ArrayList<>();
    }
    
    

    public List<String> getUserRule() {
        return userRule;
    }

    public void setUserRule(List<String> userRule) {
        this.userRule = userRule;
    }
    

    public List<UserRule> getSelectedRule() {
        return selectedRule;
    }

    public void setSelectedRule(List<UserRule> selectedRule) {
        this.selectedRule = selectedRule;
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

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvDescription() {
        return vDescription;
    }

    public void setvDescription(String vDescription) {
        this.vDescription = vDescription;
    }
    
    

    public List<UserType> getUserType() {
        UserTypeService userTypeServiceImp = new UserTypeServiceImp();
        return userTypeServiceImp.getAllUserTypes();
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        selectedRule.clear();
        id = ((UserType) event.getObject()).getId();
        UserTypeServiceImp userTypeServiceImp = new UserTypeServiceImp();
        UserType userType = userTypeServiceImp.getUserTypeDetaile(id);
        vName = userType.getName();
        vDescription = userType.getDescription();


    }
    
    public List<Rule> getAllRule() {
        AuthorityService service = new AuthorityServiceImp();
        return service.getAllAuthority();
    }
    
    public void saveRule(){
        AuthorityService service = new AuthorityServiceImp();
        
        for (int i = 0 ;i< userRule.size() ;i++) {
            int r = Integer.parseInt(userRule.get(i));
            int t = id;
            System.out.println("com.beans.settingBean.saveRule() "+userRule.get(i));
            UserRule ou = new UserRule();
            ou.setRuleId(new Rule(r));
            ou.setUserTypeId(new UserType(t));
            selectedRule.add(ou);
        }
        service.saveUserAuthority(selectedRule,id);
        info("ثبت شد.");
    }

}
