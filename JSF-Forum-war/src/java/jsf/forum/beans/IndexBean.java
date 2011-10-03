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
import jsf.forum.controller.ForumController;
import jsf.forum.entities.Category;
import jsf.forum.entities.Forum;
import org.apache.log4j.Logger;

/**
 *
 * @author Tobi
 */
@ManagedBean(name = "IndexBean")
@RequestScoped
public class IndexBean {

   @EJB
   private ForumController forumCtr;
   @EJB
   private CategoryController categoryCtr;
   Logger log = Logger.getLogger(IndexBean.class);
   private List<Forum> forums;

   public List<Forum> getForums() {

	 if (forums == null) {
	    try {
		  forums = forumCtr.getAllForums();
		  for (Forum forum : forums) {

			List<Category> categories = (List) forum.getCategories();
			for (Category c : categories) {
			   c.setTopics(categoryCtr.getTopicsForCategory(c));
			}
		  }
	    } catch (Exception e) {
		  log.error("Error on getForums maybe IndexPage is not visible");
		  return null; //TODO sollte noch angepasst werden, sonst gibts nur ne nullpointer
	    }
	 }
	 return forums;
   }
}
