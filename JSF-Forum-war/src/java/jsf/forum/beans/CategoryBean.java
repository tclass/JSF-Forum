/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.forum.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jsf.forum.controller.CategoryController;
import jsf.forum.entities.Category;
import jsf.forum.entities.Topic;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@ManagedBean(name = "CategoryBean")
@RequestScoped
public class CategoryBean {

	Logger log = Logger.getLogger(CategoryBean.class);
	@EJB
	private transient CategoryController categoryCtr;
	private Long id;
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public List<Topic> getTopics() {

		if (id != 0) {
			category = categoryCtr.getCategoryById(id);
			return categoryCtr.getTopicsForCategory(category);

		}
		//id is null, so no Topics can be found
		return null;
	}
}
