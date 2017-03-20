/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.dao;

import com.will.jsfcrud.model.Dog;

/**
 *
 * @author will
 */
public class DogDAO extends GenericDAO<Dog> {
    private static final long serialVersionUID = 1L;
    
    public DogDAO() {
        super(Dog.class);
    }
    
    public void delete(Dog dog) {
        super.delete(dog, Dog.class);
    } 
}
