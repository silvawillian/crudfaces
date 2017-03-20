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
@NamedQuery(name = "Person.findUserByIdWithDogs", query = "select p from Person p left join fetch p.dogs where p.id = :personId")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String FIND_USER_BY_ID_WITH_DOGS = "Person.findUserByIdWithDogs";
    
    @Id
    private int id;
    private int age;
    private String name;
    
    @ManyToMany
    private List<Dog> dogs;

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

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.getId() == id;
            
        }
        
        return false;
    }
}
