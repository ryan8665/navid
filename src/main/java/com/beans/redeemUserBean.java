/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Redeem;
import com.entity.RedeemUser;
import com.service.FinanceService;
import com.service.FinanceServiceImp;
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
public class redeemUserBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private Date vDuoDate;
    private String vCode;
    private String vAmount;
    private String vUser;
    private String vDescription;

    public Date getvDuoDate() {
        return vDuoDate;
    }

    public void setvDuoDate(Date vDuoDate) {
        this.vDuoDate = vDuoDate;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public String getvAmount() {
        return vAmount;
    }

    public void setvAmount(String vAmount) {
        this.vAmount = vAmount;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getvDescription() {
        return vDescription;
    }

    public void setvDescription(String vDescription) {
        this.vDescription = vDescription;
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
    
    
    public List<RedeemUser> getAllRedeenUser(){
        FinanceService financeService = new FinanceServiceImp();
        return financeService.getAllRedeemUser();
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((RedeemUser) event.getObject()).getId();
        FinanceService financeService = new FinanceServiceImp();
        RedeemUser redeemUser = financeService.getRedeemUserById(id);
        try {
            vDuoDate = redeemUser.getDuoDate();
        } catch (Exception e) {
            vDuoDate = null;
        }
        vDescription= redeemUser.getDescription();
        vUser = redeemUser.getUserId().getName() + " " + redeemUser.getUserId().getFamily();
        vAmount = redeemUser.getRedeemId().getAmount();
        vCode = redeemUser.getRedeemId().getCode();

    }
    
}
