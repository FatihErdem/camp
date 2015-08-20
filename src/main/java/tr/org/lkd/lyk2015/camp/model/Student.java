package tr.org.lkd.lyk2015.camp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends AbstractUser {

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToMany(mappedBy = "owner")
    private Set<Application> applications = new HashSet<>();

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    private enum Sex {
        MALE,
        FEMALE;
    }
}
