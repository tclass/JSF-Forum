package jsf.forum.controller;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jsf.forum.entities.Post;
import jsf.forum.entities.Topic;
import jsf.forum.entities.User;
import org.apache.log4j.Logger;

/**
 *
 * @author royalclass
 */
@Stateless
public class PostController {

    @PersistenceContext
    private EntityManager em;
    Logger log = Logger.getLogger(PostController.class);

    public void createPost(User user, String text, Topic topic) throws Exception {
        log.info("Create new Post in Topic: " + topic.getName());

        Post post = new Post(text, topic, user);

        em.persist(post);
    }

    public Post getPostById(Long id) {
        Post post = em.find(Post.class, id);
        return post;
    }
    
}
