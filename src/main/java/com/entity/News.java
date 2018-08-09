/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ryan
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByBrif", query = "SELECT n FROM News n WHERE n.brif = :brif"),
    @NamedQuery(name = "News.findByNews", query = "SELECT n FROM News n WHERE n.news = :news"),
    @NamedQuery(name = "News.findByDate", query = "SELECT n FROM News n WHERE n.date = :date")})
public class News implements Serializable {

    @JoinColumn(name = "global_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GlobalStatus globalStatusId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "title")
    private String title;
    @Size(max = 300)
    @Column(name = "brif")
    private String brif;
    @Size(max = 1000)
    @Column(name = "news")
    private String news;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "news_cat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NewsCat newsCatId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public News() {
    }

    public News(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrif() {
        return brif;
    }

    public void setBrif(String brif) {
        this.brif = brif;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NewsCat getNewsCatId() {
        return newsCatId;
    }

    public void setNewsCatId(NewsCat newsCatId) {
        this.newsCatId = newsCatId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.News[ id=" + id + " ]";
    }

    public GlobalStatus getGlobalStatusId() {
        return globalStatusId;
    }

    public void setGlobalStatusId(GlobalStatus globalStatusId) {
        this.globalStatusId = globalStatusId;
    }
    
}
