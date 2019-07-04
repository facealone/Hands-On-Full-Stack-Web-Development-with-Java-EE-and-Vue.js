/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {
@PersistenceContext
    private EntityManager em;
    public Collection<User> allUsers() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
