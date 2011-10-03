package jsf.forum.controller;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jsf.forum.entities.Category;
import jsf.forum.entities.Forum;
import org.apache.log4j.Logger;

/**
 *
 * @author royalclass
 */
@Stateless
public class CategoryController {

    @PersistenceContext
    private EntityManager em;
    Logger log = Logger.getLogger(CategoryController.class);

    public void createCategory(String name, String description, Forum forum) throws Exception {
        log.info("Create new Category: " + name);

        Category category = new Category(name, description, forum);

        em.persist(category);
    }

    public Category getCategoryById(Long id) {
        Category category = em.find(Category.class, id);
        return category;
    }

    public Category getCategoryByName(String name){
         Query q = em.createNamedQuery("category.ByName");
         q.setParameter("name", name);
         Category category = (Category) q.getSingleResult();
    
         return category;
    }
    
    
    public List getTopicsForCategory(Category c) {
             
         Query q = em.createNamedQuery("Category.getTopics");
         q.setParameter("categoryId", c.getId());
         List topics = q.getResultList();

         return topics;
}
      public List getAllCategories() {
        List categories = em.createQuery("SELECT c from Category c").getResultList();
        return categories;
    }
    
}
