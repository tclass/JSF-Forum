package jsf.forum.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author royalclass
 */
@NamedQueries({
        @NamedQuery(name="category.ByName", query="SELECT c from Category c where c.name = :name"),
        @NamedQuery(name="Category.getTopics", query="SELECT t FROM Topic t, Category c WHERE t.category.id = :categoryId group by t.id")
})

@Entity
@Table(name = "Category")
@TableGenerator(name = "CategoryGenerator", table = "Category", pkColumnName = "id")
public class Category extends GlobalTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "Category_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Category_SEQ")
    private Long id;
    
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Forum forum;

    @OneToMany(targetEntity = Topic.class, mappedBy = "category")
    private Collection topics;
		
    public Category() {
    }

    public Category(String name, String description, Forum forum) {
        this.name = name;
        this.description = description;
        this.created = new Date();
        this.forum = forum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
    
    public void setTopics(List<Topic> topics){
	  this.topics = topics;
    }

    public Collection getTopics() {
        return topics;
    }
}
