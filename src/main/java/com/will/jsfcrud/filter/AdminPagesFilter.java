/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.filter;

import com.will.jsfcrud.model.User;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author willian.silva
 */
public class AdminPagesFilter extends AbstractFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        User user = (User) req.getSession(true).getAttribute("user");
        
        if (!user.isAdmin()) {
            accessDenied(request, response, req);
            return;
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    
}
