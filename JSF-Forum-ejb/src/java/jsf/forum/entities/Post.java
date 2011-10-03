package jsf.forum.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author royalclass
 */
@Entity
@Table(name = "Post")
@TableGenerator(name="PostGenerator",table="Post", pkColumnName="id")
public class Post extends GlobalTable implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @SequenceGenerator(name="Post_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="Post_SEQ")
    private Long id;

    @Column(name="text",nullable=false,columnDefinition="TEXT")
    private String text;

    //One Topic has many posts	
    @ManyToOne
    private Topic topic;
	
    //One User has many Posts	
    @ManyToOne
    private User user;
		
	public Post() {
	}
	
	public Post(String text, Topic topic, User user) {
		this.text = text;
		this.topic = topic;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Post)) {
			return false;
		}
		Post other = (Post) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "jsf.forum.entities.Post[ id=" + id + " ]";
	}
	
}
