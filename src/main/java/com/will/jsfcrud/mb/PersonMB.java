/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.mb;

import com.will.jsfcrud.facade.DogFacade;
import com.will.jsfcrud.facade.PersonFacade;
import com.will.jsfcrud.model.Dog;
import com.will.jsfcrud.model.Person;
import java.io.Serializable;
import java.util.List;
import com.sun.faces.context.flash.ELFlash;
import java.util.ArrayList;

/**
 *
 * @author willian.silva
 */
public class PersonMB extends AbstractMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SELECTED_PERSON = "selectedPerson";

    private Dog dog;
    private Person person;
    private Person personWithDogs;
    private Person personWithDogsForDetail;

    private List<Dog> allDogs;
    private List<Person> persons;

    private DogFacade dogFacade;
    private PersonFacade personFacade;

    public void createPerson() {
        try {
            getPersonFacade().createPerson(person);
            closeDialog();
            displayInfoMessageToUser("Created with success!");
            loadPersons();
            resetPerson();
            
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not create. Try again...");
            e.printStackTrace();

        }
    }

    public void updatePerson() {
        try {
            getPersonFacade().updatePerson(person);
            closeDialog();
            displayInfoMessageToUser("Updated with success!");
            loadPersons();
            resetPerson();
            
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not update. Try again...");
            e.printStackTrace();
        }
    }
    
    public void deletePerson() {
        try {
            getPersonFacade().updatePerson(person);
            closeDialog();
            displayInfoMessageToUser("Deleted with success!");
            loadPersons();
            resetPerson();
        
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not delete. Try again...");
            e.printStackTrace();
            
        }
    }
    
    public void addDogToPerson() {
        try {
            getPersonFacade().addDogToPerson(dog.getId(), personWithDogs.getId());
            closeDialog();
            displayInfoMessageToUser("Added with success!");
            loadPersons();
            resetPerson();            
            
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not add. Try again...");
            e.printStackTrace();
        }
    }
    
    public void removeDogFromPerson() {
        try {
            getPersonFacade().removeDogFromPerson(dog.getId(), personWithDogs.getId());
            closeDialog();
            displayInfoMessageToUser("Removed with success!");
            loadPersons();
            resetPerson();  
            
        } catch (Exception e) {
            keepDialogOpen();
            displayErrorMessageToUser("Ops! Could not remove. Try again...");
            e.printStackTrace();
        }
    }
    
    public Person getPersonWithDogs() {
        if (personWithDogs == null) {
            if (person == null) {
                person = (Person) ELFlash.getFlash().get(SELECTED_PERSON);
            }
            
            personWithDogs = getPersonFacade().findPersonWithAllDogs(person.getId());
        }
        
        return personWithDogs;
    }
    
    public void setPersonWithDogsForDetail(Person person) {
        personWithDogsForDetail = getPersonFacade().findPersonWithAllDogs(person.getId());
    }
    
    public Person getPersonWithDogsForDetail() {
        if (personWithDogsForDetail == null) {
            personWithDogsForDetail = new Person();
            personWithDogsForDetail.setDogs(new ArrayList<Dog>());
        }
        
        return personWithDogsForDetail;
    }
    
    public void resetPersonWithDogsForDetail() {
        personWithDogsForDetail = new Person();
    }
    
    public String editPersonDogs() {
        ELFlash.getFlash().put(SELECTED_PERSON, person);
        return "/pages/protected/defaultUser/personDogs/personDogs.xhtml";
    }
    
    public List<Dog> complete(String name) {
        List<Dog> queryResult = new ArrayList<>();
        
        if (allDogs == null) {
            dogFacade = new DogFacade();
            allDogs = dogFacade.listAll();
        }
        
        allDogs.removeAll(personWithDogs.getDogs());
        
        for (Dog dog: allDogs) {
            if (dog.getName().toLowerCase().contains(name.toLowerCase())) {
                queryResult.add(dog);
            }
        }
        
        return queryResult;
    }
    
    private PersonFacade getPersonFacade() {
        if (personFacade == null) {
            personFacade = new PersonFacade();
        }

        return personFacade;
    }
    
    public Person getPerson() {
        if (person == null) {
            person = new Person();
        }
        
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public List<Person> getAllPersons() {
        if (persons == null) {
            loadPersons();
        }
        
        return persons;
    }
    
    private void loadPersons() {
        persons = getPersonFacade().listAll();
    }

    private void resetPerson() {
        person = new Person();
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
    
    public void resetDog() {
        dog = new Dog();
    }
    
    private void reloadPersonWithDogs() {
        personWithDogs = getPersonFacade().findPersonWithAllDogs(person.getId());
    }
}
