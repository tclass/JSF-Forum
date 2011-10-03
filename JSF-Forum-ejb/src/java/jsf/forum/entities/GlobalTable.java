/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Tobi
 */
@MappedSuperclass
public class GlobalTable {

    @Column(name = "created", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date created;

    @Column(name = "last_update")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    protected Date getUpdate(){
        return updated;
    }

    protected Date getCreated(){
        return created;
    }
}
