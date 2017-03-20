/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.filter;

import com.will.jsfcrud.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author willian.silva
 */
public class LoginCheckFilter extends AbstractFilter implements Filter {
    private static List<String> allowedURIs;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (allowedURIs == null) {
            allowedURIs = new ArrayList<>();
            allowedURIs.add(filterConfig.getInitParameter("loginActionURI"));
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/main.css.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/theme.css.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/primefaces.js.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/primefaces.css.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/jquery/jquery.js.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/messages/messages.png.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/images/ui-icons_2e83ff_256x240.png.xhtml");
            allowedURIs.add("/JSFCrudApp/javax.faces.resource/images/ui-icons_38667f_256x240.png.xhtml");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        
        if (session.isNew()) {
            doLogin(request, response, req);
            return;
        }
        
        User user = (User) session.getAttribute("user");
        
        if (user == null && !allowedURIs.contains(req.getRequestURI())) {
            System.out.println(req.getRequestURI());
            doLogin(request, response, req);
            return;
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
}
