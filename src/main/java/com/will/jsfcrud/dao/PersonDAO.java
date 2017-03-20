/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.dao;

import com.will.jsfcrud.model.Person;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author will
 */
public class PersonDAO extends GenericDAO<Person> {
    private static final long serialVersionUID = 1L;
    
    public PersonDAO() {
        super(Person.class);
    }
    
    public Person findPersonWithAllDogs(int personId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("personId", personId);
        
        return super.findOneResult(Person.FIND_USER_BY_ID_WITH_DOGS, parameters);
    }
    
    public void delete(Person person) {
        super.delete(person.getId(), Person.class);
    }
}
