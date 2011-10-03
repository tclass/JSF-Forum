/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jsf.forum.entities.User;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@Stateless
public class UserController {

    @PersistenceContext
    private EntityManager em;
    
   private Logger log = Logger.getLogger(UserController.class);


    public void createUser(String username, String password, String firstname, String lastname, int age, String email) throws Exception {
        log.info("Create new User: "+username+"; Email: "+email);

        User user = new User(username, password, firstname, lastname, age, email);    
        em.persist(user);

    }
}
