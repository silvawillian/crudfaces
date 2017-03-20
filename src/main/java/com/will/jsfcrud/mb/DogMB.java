/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.mb;

import java.io.Serializable;
import java.util.List;

import com.will.jsfcrud.facade.DogFacade;
import com.will.jsfcrud.model.Dog;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author willian.silva
 */
@ViewScoped
@ManagedBean
public class DogMB extends AbstractMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Dog dog;
    private List<Dog> dogs;
    private DogFacade dogFacade;

    public DogFacade getDogFacade() {
        if (dogFacade == null) {
            dogFacade = new DogFacade();
        }

        return dogFacade;
    }

    public Dog getDog() {
        if (dog == null) {
            dog = new Dog();
        }

        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void createDog() {
        try {
            getDogFacade().createDog(dog);
            closeDialog();
            displayInfoMessageToUser("Created with Success!");
            loadDogs();
            resetDog();

        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not create. Try again...");
            e.printStackTrace();

        }
    }

    public void updateDog() {
        try {
            getDogFacade().updateDog(dog);
            closeDialog();
            displayInfoMessageToUser("Updated with success");
            loadDogs();
            resetDog();

        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not update. Try again...");
            e.printStackTrace();

        }
    }

    public void deleteDog() {
        try {
            getDogFacade().deleteDog(dog);
            closeDialog();
            displayInfoMessageToUser("Deleted with success");
            loadDogs();
            resetDog();

        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not update. Try again...");
            e.printStackTrace();

        }
    }

    public List<Dog> getAllDogs() {
        if (dogs == null) {
            loadDogs();
        }

        return dogs;
    }

    private void resetDog() {
        dog = new Dog();

    }

    private void loadDogs() {
        dogs = getDogFacade().listAll();

    }

}
