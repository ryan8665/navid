/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.GlobalStatus;
import com.entity.Redeem;
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
public class redeemBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private Date vdatecreat,datecreat;
    private Date vdateexpire,dateexpire;
    private String vGlobalStatus;
    private Integer vMaxUser,GlobalStatus,MaxUser;
    private String vCode,Code;
    private String vDespription,Despription;
    private String vName,Name;
    private String vAmount,Amount;

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

    public Date getVdatecreat() {
        return vdatecreat;
    }

    public void setVdatecreat(Date vdatecreat) {
        this.vdatecreat = vdatecreat;
    }

    public Date getDatecreat() {
        return datecreat;
    }

    public void setDatecreat(Date datecreat) {
        this.datecreat = datecreat;
    }

    public Date getVdateexpire() {
        return vdateexpire;
    }

    public void setVdateexpire(Date vdateexpire) {
        this.vdateexpire = vdateexpire;
    }

    public Date getDateexpire() {
        return dateexpire;
    }

    public void setDateexpire(Date dateexpire) {
        this.dateexpire = dateexpire;
    }

    public String getvGlobalStatus() {
        return vGlobalStatus;
    }

    public void setvGlobalStatus(String vGlobalStatus) {
        this.vGlobalStatus = vGlobalStatus;
    }

    public Integer getvMaxUser() {
        return vMaxUser;
    }

    public void setvMaxUser(Integer vMaxUser) {
        this.vMaxUser = vMaxUser;
    }

    public Integer getGlobalStatus() {
        return GlobalStatus;
    }

    public void setGlobalStatus(Integer GlobalStatus) {
        this.GlobalStatus = GlobalStatus;
    }

    public Integer getMaxUser() {
        return MaxUser;
    }

    public void setMaxUser(Integer MaxUser) {
        this.MaxUser = MaxUser;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getvDespription() {
        return vDespription;
    }

    public void setvDespription(String vDespription) {
        this.vDespription = vDespription;
    }

    public String getDespription() {
        return Despription;
    }

    public void setDespription(String Despription) {
        this.Despription = Despription;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getvAmount() {
        return vAmount;
    }

    public void setvAmount(String vAmount) {
        this.vAmount = vAmount;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

   

   
    
    
    
    public List<Redeem> getAllRedeem(){
        FinanceService of = new FinanceServiceImp();
        return of.getAllRedeem();
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Redeem) event.getObject()).getId();
        FinanceService financeService = new FinanceServiceImp();
        Redeem redeem = financeService.geTredeemById(id);
        try {
            vdatecreat = redeem.getCreateDate();
            vdateexpire = redeem.getExpireDate();
        } catch (Exception e) {
            vdatecreat = null;
            vdateexpire = null;
        }

        vGlobalStatus = redeem.getGlobalStatusId().getName();
        vMaxUser = redeem.getMaxUser();
        vCode = redeem.getCode();
        vDespription = redeem.getDespription();
        vName= redeem.getName();
        vAmount = redeem.getAmount();
        
    }
    
    public void saveRedeem(){
        FinanceService financeService = new FinanceServiceImp();
        Redeem redeem = new Redeem();
        redeem.setAmount(Amount);
        redeem.setCode(Code);
        redeem.setExpireDate(datecreat);
        redeem.setCreateDate(new Date());
        redeem.setDespription(Despription);
        redeem.setMaxUser(MaxUser);
        redeem.setName(Name);
        redeem.setGlobalStatusId(new GlobalStatus(1));
        financeService.saveRedeem(redeem);
        info("ثبت شد.");

        
    }
    
    public void updateStatus() {
        FinanceService financeService = new FinanceServiceImp();
        financeService.changeRedeenStatus(id);
        disable = true;

    }
    
}
