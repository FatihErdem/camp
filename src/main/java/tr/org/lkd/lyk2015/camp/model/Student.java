package tr.org.lkd.lyk2015.camp.model;


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
    private Set<ApplicationForm> applicationForms = new HashSet<>();

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    private enum Sex {
        MALE,
        FEMALE;
    }

    public Set<ApplicationForm> getApplicationForms() {
        return applicationForms;
    }

    public void setApplicationForms(Set<ApplicationForm> applicationForms) {
        this.applicationForms = applicationForms;
    }
}
