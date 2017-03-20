/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.dao;

import com.will.jsfcrud.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author will
 */
public class UserDAO extends GenericDAO<User> {
    
	private static final long serialVersionUID = 1L;

	public UserDAO() {
        super(User.class);
    }
    
    public User findUserByEmail(String email) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", email);
        
        return super.findOneResult(User.FIND_BY_EMAIL, parameters);
        
    }
    
}
