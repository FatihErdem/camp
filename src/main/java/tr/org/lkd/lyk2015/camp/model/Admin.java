package tr.org.lkd.lyk2015.camp.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends AbstractUser {

    @Column(unique = true)
    @NotEmpty
    private String lkdNo;

    public String getLkdNo() {
        return lkdNo;
    }

    public void setLkdNo(String lkdNo) {
        this.lkdNo = lkdNo;
    }
}
