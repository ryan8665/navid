/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.Chapter;
import com.entity.GlobalStatus;
import com.entity.Media;
import com.entity.MediaType;
import com.entity.User;
import com.service.EducationService;
import com.service.EducationServiceImp;
import com.service.FileService;
import com.service.FileServiceImp;
import com.service.LibraryService;
import com.service.LibraryServiceImp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ryan
 */
@ManagedBean
@ViewScoped
public class libraryBean extends BaseBean{
    private boolean disable = true;
    private int id;
    private Date vdate;
    private String vuser;
    private String vmediatype,mediatype,chapter;
    private String vmediname,name;
    private String vdescription,description;
    private String vname;
    private String downloadLink;
    private String uploadFile;

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getVmediname() {
        return vmediname;
    }

    public void setVmediname(String vmediname) {
        this.vmediname = vmediname;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public String getVuser() {
        return vuser;
    }

    public void setVuser(String vuser) {
        this.vuser = vuser;
    }

    public String getVmediatype() {
        return vmediatype;
    }

    public void setVmediatype(String vmediatype) {
        this.vmediatype = vmediatype;
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
    
    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }
    
    
    public List<Media> allMedia(){
        LibraryService libraryService = new LibraryServiceImp();
        return libraryService.getAllLibrary();
    }
    
    public List<Media> allMediaByUser() {
        LibraryService libraryService = new LibraryServiceImp();
        return libraryService.getUserLibrary(getUserID());
    }
    
    public void updateLibraryStatus() {
        LibraryService libraryService = new LibraryServiceImp();
        libraryService.changeLibraryStatus(id);
        disable = true;

    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        id = ((Media) event.getObject()).getId();
        LibraryService libraryService = new LibraryServiceImp();
        Media media = libraryService.getLibraryById(id);
        vuser = media.getUserId().getName() + " " + media.getUserId().getFamily();
        try {
            vdate = media.getDate();
        } catch (Exception e) {
            vdate = null;
        }

        vmediatype = media.getMediaTypeId().getType();
        vdescription = media.getDescription();
        vmediname = media.getMediaTypeId().getName();
        vname = media.getName();
        downloadLink = "/resources/media/" + id + "."+vmediatype;
        uploadFile = "/(\\.|\\/)(jpg)$/";
       
     
    }

   
    
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FileService fileService = new FileServiceImp();
        FacesMessage message = new FacesMessage("آپلود شد", " آپلود شد.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        ServletContext ctx = (ServletContext) FacesContext
                .getCurrentInstance().getExternalContext().getContext();
        String absoluteDiskPath = ctx.getRealPath("/resources/");
        System.out.println("----------- " + absoluteDiskPath);
        fileService.copyStream(event.getFile().getInputstream(), absoluteDiskPath + "/media/" + id ,vmediatype);

    }
    
    public void saveToLibrary(){
        LibraryService libraryService = new LibraryServiceImp();
        Media om = new Media();
        om.setDate(new Date());
        om.setName(name);
        om.setDescription(description);
        Chapter oc = new Chapter(Integer.parseInt(chapter));
        MediaType omt = new MediaType(Integer.parseInt(mediatype));
        GlobalStatus og = new GlobalStatus(1);
        om.setChapterId(oc);
        om.setMediaTypeId(omt);
        om.setGlobalStatusId(og);
        User ou = new User(getUserID());
        om.setUserId(ou);
        libraryService.saveMedia(om);
                
        mediatype = chapter = description = name = "";
    }
    
    public List<MediaType> getAllMediaType(){
        LibraryService libraryService = new LibraryServiceImp();
        return libraryService.getMediaType();
    }
    
    public List<Chapter> getAllChapter(){
        EducationService educationService =  new EducationServiceImp();
        return educationService.getAllChapter();
    }
    
}
