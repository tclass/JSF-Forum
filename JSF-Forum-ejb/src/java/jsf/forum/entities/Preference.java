/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf.forum.entities;

import java.io.Serializable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.UserTransaction;

/**
 *
 * @author Tobi
 */
@Entity
public class Preference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String schluessel;
    private String wert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWert(){
        return wert;
    }

    public void setWert(String wert){
        this.wert= wert;
    }

    public String getSchluessel(){
        return schluessel;
    }

    public void setSchluessel(String schluessel){
        this.schluessel = schluessel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Preference)) {
            return false;
        }
        Preference other = (Preference) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.forum.Preferences[id=" + id + "]";
    }


}
