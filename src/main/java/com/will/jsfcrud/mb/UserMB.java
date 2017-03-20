/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.mb;

import com.will.jsfcrud.model.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author willian.silva
 */
@SessionScoped
@ManagedBean(name = "userMB")
public class UserMB implements Serializable {

    public static final String INJECTION_NAME = "#{userMB}";
    private static final long serialVersionUID = 1L;

    private User user;

    public boolean isAdmin() {
        return user.isAdmin();
    }
    
    public boolean isDefaultUser() {
        return user.isUser();
    }
    
    public String logOut() {
        getRequest().getSession().invalidate();
        return "pages/public/login.xhtml";
    }
    
    private HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}
