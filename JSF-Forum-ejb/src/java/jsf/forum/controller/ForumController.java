/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jsf.forum.entities.Forum;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@Stateless
public class ForumController {

    @PersistenceContext
    private EntityManager em;
    private Logger log = Logger.getLogger(ForumController.class);

    /**
     * Creates new Forum with the givin name and description
     */
    public void createForum(String name, String description) throws Exception {
        log.info("Create new Forum: " + name);

        Forum forum = new Forum(name, description);
        em.persist(forum);
    }

    public Forum getForumById(Long id) {
        Forum forum = em.find(Forum.class, id);
        return forum;
    }

    public List getAllForums() {
        List forums = em.createQuery("SELECT f from Forum f").getResultList();
        return forums;
    }
}
