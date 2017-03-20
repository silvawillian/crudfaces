/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author willian.silva
 */
public class AbstractFilter {
    public AbstractFilter() {
        super();
    }
    
    protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/pages/public/login.xhtml");
        rd.forward(request, response);
    }
    
    protected void accessDenied(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/pages/public/accessDenied.xhtml");
        rd.forward(request, response);
    }
    
}
