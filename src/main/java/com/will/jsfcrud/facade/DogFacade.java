/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.facade;

import com.will.jsfcrud.dao.DogDAO;
import com.will.jsfcrud.model.Dog;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author will
 */
public class DogFacade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private DogDAO dogDAO = new DogDAO();
    
    public void createDog(Dog dog) {
        dogDAO.beginTransaction();
        dogDAO.save(dog);
        dogDAO.commitAndCloseTransaction();
    }
    
    public void updateDog(Dog dog) {
        dogDAO.beginTransaction();
        Dog persistedDog = dogDAO.find(dog.getId());
        persistedDog.setAge(dog.getAge());
        persistedDog.setName(dog.getName());
        dogDAO.update(persistedDog);
        dogDAO.commitAndCloseTransaction();
    }   
    
    public Dog findDog(int dogId) {
        dogDAO.beginTransaction();
        Dog dog = dogDAO.find(dogId);
        dogDAO.closeTransaction();
        return dog;
    }
    
    public List<Dog> listAll() {
        dogDAO.beginTransaction();
        List<Dog> result = dogDAO.findAll();
        dogDAO.closeTransaction();
        return result;
    }
    
    public void deleteDog(Dog dog) {
        dogDAO.beginTransaction();
        Dog persistedDog = dogDAO.findReferenceOnly(dog.getId());
        dogDAO.delete(persistedDog);
        dogDAO.commitAndCloseTransaction();
    }
}
