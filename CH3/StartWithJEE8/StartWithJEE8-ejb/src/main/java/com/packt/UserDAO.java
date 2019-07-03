/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt;

import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class UserDAO {
    private final EntityManager em;
    
    public UserDAO(EntityManager em){
        this.em = em;
    }
    
    
}
