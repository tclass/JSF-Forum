package jsf.forum.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author royalclass
 */
@Entity
@Table(name = "Forum")
@TableGenerator(name="ForumGenerator",table="Forum", pkColumnName="id")
public class Forum extends GlobalTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Forum_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator="Forum_SEQ")
    private Long id;

    @Column(name="name",nullable=false, length=50)
    private String name;

    @Column(name="description",nullable=false,columnDefinition="TEXT")
    private String description;

    @OneToMany(targetEntity=Category.class,mappedBy="forum",fetch=FetchType.EAGER)
    private Collection categories;

    public Forum() {
    }

    public Forum(String name, String description){
        this.name = name;
        this.description = description;
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

     public void addCategory(Category category) {
      //wenn category noch nicht vorhanden dann anlegen
        if (!getCategories().contains(category) || category == null) {
            getCategories().add(category);
        }
    }

    public Collection getCategories() {
        return categories;
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
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
