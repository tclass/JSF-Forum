/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Tobi
 */
//@NamedQuery
@NamedQuery(name = "Userlogin", query = "SELECT u FROM User u WHERE u.password = :password and u.username = :username")
//
@Entity(name = "User")
@Table(name = "User")
@TableGenerator(name = "UserGenerator", table = "User", pkColumnName = "id")
public class User extends GlobalTable implements Serializable {

    @Id
    @SequenceGenerator(name = "User_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "User_SEQ")
    private int id;

    @Column(name = "username", nullable = false, columnDefinition = "varchar(30) COLLATE utf8_bin")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(30) COLLATE utf8_bin")
    private String password;

    @Column(name = "firstname", nullable = true, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = true, length = 50)
    private String lastname;

    @Column(name = "age", nullable = true, length = 3)
    private int age;

    @Column(name = "position", nullable = false, length = 1)
    private int position;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @OneToMany(targetEntity = Topic.class, mappedBy = "user")
    private Collection threads;

    public User() {
    }

    public User(String username, String password, String firstname, String lastname, int age, String email) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.email = email;
        this.position = 0;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void addThread(Topic thread) {
        //wenn category noch nicht vorhanden und nicht null dann anlegen
        if (!getThreads().contains(thread) || thread == null) {
            getThreads().add(thread);
        }
    }

    public Collection getThreads() {
        return threads;
    }
}
