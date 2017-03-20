/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.facade;

import com.will.jsfcrud.dao.UserDAO;
import com.will.jsfcrud.model.User;

/**
 *
 * @author will
 */
public class UserFacade {
    UserDAO userDAO = new UserDAO();
    
    public User isValidLogin(String email, String password) {
        userDAO.beginTransaction();
        User user = userDAO.findUserByEmail(email);
        
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        
        return user;
    }
}
