/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jsf.forum.entities.Category;
import jsf.forum.entities.Topic;
import jsf.forum.entities.User;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@Stateless
public class TopicController {

    @PersistenceContext
    private EntityManager em;
    Logger log = Logger.getLogger(TopicController.class);

    /*
	* returns the Topic that was persist 
     */
    public Topic newTopic(String name, int type,Category category, User user) throws Exception {
        log.debug("Create new Topic: " + name + " in "+ category.getName());

        Topic topic = new Topic(name, type, category,user);
        em.persist(topic);
	   return topic;
    }

    public Topic getTopicById(Long id) {
        Topic topic = em.find(Topic.class, id);
        return topic;
    }
}
