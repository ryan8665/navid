/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import com.beans.main;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryan
 */
@WebFilter(filterName = "access", urlPatterns = {"/admin"})
public class access implements Filter {
   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        com.beans.main loginBean = null;
        String contextPath = ((HttpServletRequest) request).getContextPath();
        try {
            loginBean = (main) ((HttpServletRequest) request).getSession().getAttribute("main");
            System.out.println("filter1    " + loginBean.getLoginDto().getLogin());
            if (!loginBean.getLoginDto().getLogin()) {
                ((HttpServletResponse) response).sendRedirect(contextPath + "/Error/access-denied.xhtml");
            }
        } catch (Exception e) {
            System.out.println("filter1    " + e.toString());
            ((HttpServletResponse) response).sendRedirect(contextPath + "/Error/access-denied.xhtml");
        }

        try {
            if (loginBean.getLoginDto().getLogin() == false) {
                System.out.println("filter2    false");
                System.out.println("filter2    getIsLOgin " + loginBean.getLoginDto().getLogin());
                System.out.println("filter2    contextPath " + contextPath.equals(""));
                ((HttpServletResponse) response).sendRedirect(contextPath + "/Error/access-denied.xhtml");
            } else {
                // System.out.println("filter3    " + loginBean.getIsLOgin());
            }
        } catch (Exception e) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.sendRedirect("/Error/access-denied.xhtml");

        }

        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }

    public void destroy() {
        // Nothing to do here!
    }

}
