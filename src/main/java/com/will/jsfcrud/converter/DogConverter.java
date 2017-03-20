/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.converter;

import com.will.jsfcrud.facade.DogFacade;
import com.will.jsfcrud.model.Dog;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.*;

/**
 *
 * @author willian.silva
 */
@FacesConverter(forClass = com.will.jsfcrud.model.Dog.class)
public class DogConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        DogFacade dogFacade = new DogFacade();
        int dogId;
        
        try {
            dogId = Integer.parseInt(value);
            
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Dog and select it (or use the dropdown)", "Type the name of a Dog and select it (or use the dropdown)"));
        }
        
        return dogFacade.findDog(dogId);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        
        Dog dog = (Dog) value;
        return String.valueOf(dog.getId());
    }
}
