/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.delivery.main.data;

import com.packt.delivery.main.data.structure.UserData;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class UserDAO {
    private final EntityManager em;
    
    public UserDAO(EntityManager em){
        this.em=em;
    }
    public List<UserData> allUsers() {
        return em.createNamedQuery("UserData.findAll", UserData.class).getResultList();
    }

    
    public UserData save(UserData user) {
        em.persist(user);
        return user;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
