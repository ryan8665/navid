/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Transaction;
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
public class financeBean extends BaseBean {

    private boolean disable = true;
    private String vuser;
    private Date vdate;
    private String vdescription;
    private String vname;
    private int id;
    private Integer vstaus;
    private String vamount;

    public String getVamount() {
        return vamount;
    }

    public void setVamount(String vamount) {
        this.vamount = vamount;
    }
    

    public String getVuser() {
        return vuser;
    }

    public void setVuser(String vuser) {
        this.vuser = vuser;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public String getVdescription() {
        return vdescription;
    }

    public void setVdescription(String vdescription) {
        this.vdescription = vdescription;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVstaus() {
        return vstaus;
    }

    public void setVstaus(Integer vstaus) {
        this.vstaus = vstaus;
    }
    

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public List<Transaction> getAllTransaction() {
        FinanceService of = new FinanceServiceImp();
        return of.getAllTransaction();
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Transaction) event.getObject()).getId();
        FinanceService financeService = new FinanceServiceImp();
        Transaction transaction = financeService.GetTransactionById(id);
        vuser = transaction.getUserId().getName() + " " + transaction.getUserId().getFamily();
        try {
            vdate = transaction.getDate();
        } catch (Exception e) {
            vdate = null;
        }

        vdescription = transaction.getDescription();
        vname= transaction.getName();
        vstaus = transaction.getStatus();
        vamount = transaction.getAmount();
    }

}
