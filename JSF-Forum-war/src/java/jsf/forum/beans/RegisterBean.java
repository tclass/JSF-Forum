/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import jsf.forum.controller.CategoryController;
import jsf.forum.controller.ForumController;
import jsf.forum.controller.UserController;
import org.apache.log4j.Logger;


/**
 *
 * @author Tobi
 */
@ManagedBean(name = "RegisterBean")
@RequestScoped
public class RegisterBean {

   
    @EJB
    private UserController userCtr;

    private Logger log = Logger.getLogger(RegisterBean.class);

    public String firstname;
    public String lastname;
    public String username;
    public String password;
    public String password2;
    public String email;
    public int age;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public String getUsername() {
        return username;
    }

    
    public String register() {
        try {

            userCtr.createUser(username, password, firstname, lastname, age, email);

        } catch (Exception e) {
            log.error("Error on Register User probably not created");

        }
        return "index";
    }
}
