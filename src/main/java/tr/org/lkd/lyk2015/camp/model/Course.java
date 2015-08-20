package tr.org.lkd.lyk2015.camp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course extends AbstractBaseModel {

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String prerequisites;
    private String detailsPageLink;

    @NotEmpty
    private Boolean active = true;

    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors = new HashSet<>();

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