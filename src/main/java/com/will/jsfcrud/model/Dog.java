/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author will
 */
@Entity
public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int age;
    private String name;
    
    @ManyToMany(mappedBy = "dogs")
    private List<Person> persons;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
    @Override
    public int hashCode() {
        return id;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            Dog dog = (Dog) obj;
            return dog.getId() == id;
        }
 
        return false;
    }
 
    @Override
    public String toString() {
        return name;
    }
}
