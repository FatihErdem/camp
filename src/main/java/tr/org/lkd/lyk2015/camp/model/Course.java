package tr.org.lkd.lyk2015.camp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Course extends AbstractBaseModel{

    private String name;
    private String description;
    private String prerequisites;
    private String detailsPageLink;

    private Boolean active = true;

    @ManyToMany
    private Set<Instructor> instructors;

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

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getDetailsPageLink() {
        return detailsPageLink;
    }

    public void setDetailsPageLink(String detailsPageLink) {
        this.detailsPageLink = detailsPageLink;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}