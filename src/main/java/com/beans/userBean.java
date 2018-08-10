/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.GeneralExamUser;
import com.entity.GlobalStatus;
import com.entity.Logs;
import com.entity.Message;
import com.entity.PackageUser;
import com.entity.Redeem;
import com.entity.Transaction;
import com.entity.User;
import com.entity.UserType;
import com.service.ExamService;
import com.service.ExamServiceImp;
import com.service.FinanceService;
import com.service.FinanceServiceImp;
import com.service.LogService;
import com.service.LogServiceImp;
import com.service.PackageService;
import com.service.PackageServiceImp;
import com.service.UserService;
import com.service.UserServiceImp;
import com.service.UserTypeService;
import com.service.UserTypeServiceImp;
import com.service.messageService;
import com.service.messageServiceImp;
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
public class userBean extends BaseBean {

    private boolean disable = true;
    private boolean isNotStudent = true;
    private int id;
    private String vUser, Name, Family;
    private String vAddress, Address;
    private Date vCreationDate, CreationDate;
    private String vStatus, Status;
    private String vMobile, Mobile;
    private String vNationalcode, Nationalcode;
    private String vPassword, Password;
    private String sms, message, title;
    private int userTypeId;

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }
    
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getvPassword() {
        return vPassword;
    }

    public void setvPassword(String vPassword) {
        this.vPassword = vPassword;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String Family) {
        this.Family = Family;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getvCreationDate() {
        return vCreationDate;
    }

    public void setvCreationDate(Date vCreationDate) {
        this.vCreationDate = vCreationDate;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date CreationDate) {
        this.CreationDate = CreationDate;
    }

    public String getvStatus() {
        return vStatus;
    }

    public void setvStatus(String vStatus) {
        this.vStatus = vStatus;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getvMobile() {
        return vMobile;
    }

    public void setvMobile(String vMobile) {
        this.vMobile = vMobile;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getvNationalcode() {
        return vNationalcode;
    }

    public void setvNationalcode(String vNationalcode) {
        this.vNationalcode = vNationalcode;
    }

    public String getNationalcode() {
        return Nationalcode;
    }

    public void setNationalcode(String Nationalcode) {
        this.Nationalcode = Nationalcode;
    }

    public boolean isIsNotStudent() {
        return isNotStudent;
    }

    public void setIsNotStudent(boolean isNotStudent) {
        this.isNotStudent = isNotStudent;
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

    public List<User> getAllUser() {
        UserService userService = new UserServiceImp();
        return userService.getAllUser();
    }

    public List<User> getAllStudent() {
        UserService userService = new UserServiceImp();
        return userService.getAllStudent();
    }

    public List<User> getAllUserWithoutAdmin() {
        UserService userService = new UserServiceImp();
        return userService.getAllUserNoAdmin();
    }

    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((User) event.getObject()).getId();
        UserService userService = new UserServiceImp();
        User user = userService.getUserById(id);
        isNotStudent = user.getUserTypeId().getId() != 4;
        vUser = user.getName() + " " + user.getFamily();
        vAddress = user.getAddress();
        vCreationDate = user.getCreationDate();
        vStatus = user.getGlobalStatusId().getName();
        vMobile = user.getMobile();
        vNationalcode = user.getNationalcode();
        vPassword = user.getPassword();

    }

    public void updateStatus() {
        UserService userService = new UserServiceImp();
        userService.changeUserStatus(id);
        disable = true;
        isNotStudent = true;

    }

    public List<Logs> getAllUserLog() {
        LogService logService = new LogServiceImp();
        return logService.getUserLogById(id);
    }

    public void sendSms() {
        com.utility.SMS._send(vMobile, sms);
    }

    public void sendMessage() {
        messageService messageService = new messageServiceImp();
        Message om = new Message();
        om.setDate(new Date());
        om.setMessage(message);
        om.setMessageFlagId(0);
        om.setReciver(new User(id));
        om.setSender(new User(getUserID()));
        om.setTitle(title);
        messageService.saveMessage(om);

    }

   

    public List<PackageUser> getPackage() {
        PackageService packageService = new PackageServiceImp();
        return packageService.getUserFromPackage(id);

    }

    public List<Transaction> getTransaction() {
        FinanceService financeService = new FinanceServiceImp();
        return financeService.getAllTransactionByUserId(id);

    }
    
    public  List<UserType> getAlluserType(){
        UserTypeService userTypeService = new UserTypeServiceImp();
        return userTypeService.getAllUserTypes();
    }

    public List<GeneralExamUser> getGeneralExam() {
        ExamService examService = new ExamServiceImp();
        return examService.getGeneralExamByUserId(id);

    }
    
    public void saveUser() {

        UserService userService = new UserServiceImp();    
        if (userService.chackUserisExist(Mobile)) {
            User ou = new User();
            ou.setAddress(Address);
            ou.setCreationDate(new Date());
            ou.setFamily(Family);
            ou.setGlobalStatusId(new GlobalStatus(1));
            ou.setLastlogin(new Date());
            ou.setMobile(Mobile);
            ou.setName(Name);
            ou.setPassword(Password);
            ou.setNationalcode(Nationalcode);
            ou.setUserTypeId(new UserType(userTypeId));
            userService.saveUser(ou);
        }

    }

}
