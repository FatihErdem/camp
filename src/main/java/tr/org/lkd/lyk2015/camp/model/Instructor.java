package tr.org.lkd.lyk2015.camp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Instructor extends AbstractUser {

    @ManyToMany(mappedBy = "instructors")
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}