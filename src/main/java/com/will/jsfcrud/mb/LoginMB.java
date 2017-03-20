/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.mb;

import com.will.jsfcrud.facade.UserFacade;
import com.will.jsfcrud.model.User;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author willian.silva
 */
@RequestScoped
@ManagedBean
public class LoginMB extends AbstractMB {
    @ManagedProperty(value = UserMB.INJECTION_NAME)
    private UserMB userMB;
    
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        UserFacade userFacade = new UserFacade();
        
        User user = userFacade.isValidLogin(email, password);
        
        if (user != null) {
            userMB.setUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getContext();
            
            request.getSession().setAttribute("user", user);
            return "/pages/protected/index.xhtml";
        }
        
        displayErrorMessageToUser("Check your email/password.");
        return null;
    }
    
    public void setUserMB(UserMB userMB) {
        this.userMB = userMB;
    }
}
