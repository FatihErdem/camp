package tr.org.lkd.lyk2015.camp.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//Abstract oldugu icin entity kullanilmayacak. Ancak diger yerlerde kullanilacagi icin su kullanilir

@MappedSuperclass
public abstract class AbstractUser extends AbstractBaseModel {

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private Integer birthDate;
    @NotEmpty
    @Column(unique = true)
    private Long tckn;
    @Column(unique = true)
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @Column(unique = true)
    @NotEmpty
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Long getTckn() {
        return tckn;
    }

    public void setTckn(Long tckn) {
        this.tckn = tckn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
