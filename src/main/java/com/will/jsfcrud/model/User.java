/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.will.jsfcrud.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author will
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
    private static final long  serialVersionUID = 1L;
    
    public static final String FIND_BY_EMAIL = "User.findUserByEmail";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
