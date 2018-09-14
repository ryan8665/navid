/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;
import com.entity.GlobalStatus;
import com.entity.Package;
import com.entity.PackageUser;
import com.service.HardnessServiceImp;
import com.service.PackageServiceImp;
import java.util.Date;
import com.entity.Hadrdness;
import com.entity.Lesson;
import com.entity.User;
import com.service.HardnessService;
import com.service.LessonService;
import com.service.LessonServiceImp;
import com.service.PackageService;
import com.service.TeacherService;
import com.service.TeacherServiceImp;
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
public class packageBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private Date vCreationDate,CreationDate;
    private Date vExpireDate,ExpireDate ,DueDate;
    private String vGlobalStatus;
    private Integer vMonths,Months;
    private String vUser;
    private String vDescrioption,Descrioption;
    private String vName,Name;
    private Integer vPrice,Price;
    private String vCourse;
    private String vLesson;
    private int lessonId;
    private String lesson,hardness ,teacher;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    
    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }
   

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
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

    public Date getvExpireDate() {
        return vExpireDate;
    }

    public void setvExpireDate(Date vExpireDate) {
        this.vExpireDate = vExpireDate;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public String getvGlobalStatus() {
        return vGlobalStatus;
    }

    public void setvGlobalStatus(String vGlobalStatus) {
        this.vGlobalStatus = vGlobalStatus;
    }

    public Integer getvMonths() {
        return vMonths;
    }

    public void setvMonths(Integer vMonths) {
        this.vMonths = vMonths;
    }

    public Integer getMonths() {
        return Months;
    }

    public void setMonths(Integer Months) {
        this.Months = Months;
    }

    public String getvUser() {
        return vUser;
    }

    public void setvUser(String vUser) {
        this.vUser = vUser;
    }

    public String getvDescrioption() {
        return vDescrioption;
    }

    public void setvDescrioption(String vDescrioption) {
        this.vDescrioption = vDescrioption;
    }

    public String getDescrioption() {
        return Descrioption;
    }

    public void setDescrioption(String Descrioption) {
        this.Descrioption = Descrioption;
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

    public Integer getvPrice() {
        return vPrice;
    }

    public void setvPrice(Integer vPrice) {
        this.vPrice = vPrice;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer Price) {
        this.Price = Price;
    }

    public String getvCourse() {
        return vCourse;
    }

    public void setvCourse(String vCourse) {
        this.vCourse = vCourse;
    }

    public String getvLesson() {
        return vLesson;
    }

    public void setvLesson(String vLesson) {
        this.vLesson = vLesson;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
    
    
    
    public List<Package> allPackage(){
        PackageService packageService = new PackageServiceImp();
        return packageService.getAllPackage();
    }
    
    public List<Package> allPackageByUser() {
        PackageService packageService = new PackageServiceImp();
        return packageService.getAllPakageByUserId(getUserID());
    }
    
    public Package packageDetaile(){
        PackageService packageService = new PackageServiceImp();
        return packageService.getPackage(id);
    }
    
    public void updateStatus(){
        PackageService packageService = new PackageServiceImp();
        packageService.changePackageStatus(id);
    }
    
    public void savePackage(int type){
        PackageService packageService = new PackageServiceImp();
        Package op = new Package();
        op.setCreationDate(new Date());
        op.setDescrioption(Descrioption);
        op.setName(Name);
        op.setExpireDate(ExpireDate);
        op.setGlobalStatusId(new GlobalStatus(1));
        op.setLessonId(new Lesson(Integer.parseInt(lesson)));
        op.setMonths(Months);
        op.setPrice(Price);
        op.setUserId(new User(getUserID()));
        packageService.savePackage(op);
        Descrioption = Name  = "";
        Months = Price = null;
        info("ثبت شد.");
    }
    
    public void onRowSelect(SelectEvent event) throws Exception {
        disable = false;
        id = ((Package) event.getObject()).getId();
        PackageService packageService = new PackageServiceImp();
        Package packag= packageService.getPackage(id);
        try {
            vCreationDate = packag.getCreationDate();
            vExpireDate = packag.getExpireDate();
        } catch (Exception e) {
            vCreationDate = null;
            vExpireDate = null;
        }
        vGlobalStatus = packag.getGlobalStatusId().getName();
        vMonths = packag.getMonths();
        vUser = packag.getUserId().getName() + " " +packag.getUserId().getFamily();
        vDescrioption = packag.getDescrioption();
        vName = packag.getName();
        vPrice = packag.getPrice();
        try {
        vLesson = packag.getLessonId().getName();
        vCourse = packag.getCourseId().getName();
        } catch (Exception e) {

        }
        
        
    }
    
    public List<PackageUser> allUserFromPackage(){
        PackageService packageService = new PackageServiceImp();
        return packageService.getUserFromPackage(id);
    }
    
    public List<Hadrdness> getAllHardness(){
        HardnessService oh = new HardnessServiceImp();
        return oh.getAllHardness();
    }
    
    public List<Lesson> getAllLesson(){
        LessonService ol = new LessonServiceImp();
        return ol.getAllLesson();
    }
    
    public List<User> AllTeacher() {
        TeacherService ot = new TeacherServiceImp();
        return ot.getAllTeachers();
    }
}
