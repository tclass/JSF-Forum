package jsf.forum.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author royalclass
 */

@Entity
@Table(name="Topic")
@TableGenerator(name="TopicGenerator",table="Topic", pkColumnName="id")
public class Topic extends GlobalTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Topic_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="Topic_SEQ")
    private Long id;

    @Column(name="name",nullable=false, length=50)
    private String name;

    @Column(name="description",nullable=false,columnDefinition="TEXT")
    private String description;
    
    @Column(name="type",nullable=false)
    private int type;
    
    @ManyToOne
    private User user;

    @ManyToOne(targetEntity=Category.class)
    private Category category;
		
   @OneToMany(targetEntity=Post.class,mappedBy="topic",fetch=FetchType.EAGER)
    private Collection posts;

    public Topic() {
    }

    public Topic(String name,String description, int type,Category category, User user) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.category = category;
	  this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
		
	public Collection getPosts() {
		return posts;
	}

	public void setPosts(Collection posts) {
		this.posts = posts;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Long) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.forum.entities.Topic[id=" + id + "]";
    }

}
