/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ryan
 */
public class BaseBean {
    
    protected int getUserID() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String contextPath = ((HttpServletRequest) request).getContextPath();
        main loginBean = (main) ((HttpServletRequest) request).getSession().getAttribute("main");
        return loginBean.getLoginDto().getId();
    }
    
}
