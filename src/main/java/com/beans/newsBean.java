/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.entity.GlobalStatus;
import com.entity.News;
import com.entity.NewsCat;
import com.entity.User;
import com.service.FileService;
import com.service.FileServiceImp;
import com.service.NewsService;
import com.service.NewsServiceImp;
import java.io.IOException;
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
public class newsBean extends BaseBean{

    private boolean disable = true;
    int nid;
    private String vnewscat,newscat;
    private String vtitle,title;
    private String vbrif,brif;
    private String vnews,news;
    private String uid;
    private Date vdate;
    private String vuser;
    private String downloadLink;

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
    

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getVnewscat() {
        return vnewscat;
    }

    public void setVnewscat(String vnewscat) {
        this.vnewscat = vnewscat;
    }

    public String getNewscat() {
        return newscat;
    }

    public void setNewscat(String newscat) {
        this.newscat = newscat;
    }

    public String getVtitle() {
        return vtitle;
    }

    public void setVtitle(String vtitle) {
        this.vtitle = vtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVbrif() {
        return vbrif;
    }

    public void setVbrif(String vbrif) {
        this.vbrif = vbrif;
    }

    public String getBrif() {
        return brif;
    }

    public void setBrif(String brif) {
        this.brif = brif;
    }

    public String getVnews() {
        return vnews;
    }

    public void setVnews(String vnews) {
        this.vnews = vnews;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
    

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }


    public void updateNewsStatus() {
        NewsService newsService = new NewsServiceImp();
        newsService.changeNewsStatus(nid);
        disable = true;
        
    }

    public void setDisableTrue() {
        disable = true;
    }
    public List<News> newsList() {
        NewsService newsService = new NewsServiceImp();
        return newsService.getNewsAll();
    }
    
    public List<NewsCat> newsCat() {
        NewsService newsService = new NewsServiceImp();
        return newsService.getNewsCat();
    }
    
    public void onRowSelect(SelectEvent event) throws ParseException {
        disable = false;
        nid = ((News) event.getObject()).getId();
        NewsService newsService = new NewsServiceImp();
        News newsO = newsService.getNewsById(nid);
        vuser = newsO.getUserId().getName() + " " + newsO.getUserId().getFamily();
        try {
            vdate = newsO.getDate();
        } catch (Exception e) {
            vdate = null;
        }

        vnewscat = newsO.getNewsCatId().getName();
        vtitle = newsO.getNews();
        vbrif = newsO.getBrif();
        vnews = newsO.getNews();
        uid = newsO.getUserId().getId() + "";
        downloadLink = "\\resources\\news\\" + nid + ".png";


    }
    
    public void addNews(){
        News on = new News();
        on.setBrif(brif);
        on.setDate(new Date());
        on.setNews(news);
        on.setTitle(title);
        GlobalStatus og = new GlobalStatus(1);
        on.setGlobalStatusId(og);
        NewsCat onc = new NewsCat(Integer.parseInt(newscat));
        on.setNewsCatId(onc);
        User ou = new User(getUserID());
        on.setUserId(ou);
        NewsService newsService = new NewsServiceImp();
        newsService.SaveNews(on);
        brif= news = title = "";
        
        
    }
    
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FileService fileService = new FileServiceImp();
        FacesMessage message = new FacesMessage("آپلود شد", " آپلود شد.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        ServletContext ctx = (ServletContext) FacesContext
                .getCurrentInstance().getExternalContext().getContext();
        String absoluteDiskPath = ctx.getRealPath("/resources/");
        System.out.println("----------- " + absoluteDiskPath);
        fileService.copyStream(event.getFile().getInputstream(), absoluteDiskPath+"/news/" + nid);
       
      
    }
    
   
}
