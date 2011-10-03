/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.forum.controller.CategoryController;
import jsf.forum.controller.SessionController;
import jsf.forum.controller.TopicController;
import jsf.forum.entities.Category;
import jsf.forum.entities.User;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@ManagedBean(name = "TopicBean")
@SessionScoped
public class TopicBean implements Serializable {

	Logger log = Logger.getLogger(TopicBean.class);
	@EJB
	private transient TopicController topicCtr;
	@EJB
	private transient CategoryController categoryCtr;
	@EJB
	private SessionController sessionCtr;
	private int categoryId;
	private String topicName;

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setTopicName(String name) {
		topicName = name;
	}

	public String getTopicName() {
		return topicName;
	}

	public String newTopic() {
		Category category = categoryCtr.getCategoryById(categoryId);
		User user = sessionCtr.getUser();
        try {

			topicCtr.newTopic(topicName, "Nichts eigentlich", 0, category, user);
		} catch (Exception e) {
			log.error(e);
		}
		return "index";
	}
}
