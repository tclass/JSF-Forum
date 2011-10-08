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
import jsf.forum.controller.PostController;
import jsf.forum.controller.SessionController;
import jsf.forum.controller.TopicController;
import jsf.forum.entities.Category;
import jsf.forum.entities.Topic;
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
	@EJB
	private PostController postCtr;
	
	private Long categoryId;
	private String topicName;
	private String postText;

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setTopicName(String name) {
		topicName = name;
	}

	public String getTopicName() {
		return topicName;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String newTopic() {
		Category category = categoryCtr.getCategoryById(categoryId);
		User user = sessionCtr.getUser();
        try {

			Topic topic = topicCtr.newTopic(topicName, 0, category, user);
			postCtr.createPost(user, postText, topic);
			
		} catch (Exception e) {
			log.error(e);
		}
		return "index";
	}
}
