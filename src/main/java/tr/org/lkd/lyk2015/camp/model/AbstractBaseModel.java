package tr.org.lkd.lyk2015.camp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@MappedSuperclass
public abstract class AbstractBaseModel {

    @Id
    @GeneratedValue
    private Long id;

    private Calendar createDate;

    private Calendar updateDate;
    private Calendar deleteDate;

    // NotNull db seviyesinde constraint olusturmak zorunda degil.
    // Hibernate olustuyor olabilir ama baska JSR303 implementasyonu olan teknolojilerde olmak zorunda degil.
    // DB seviyesinde olmasinin sebebi elle girislerde sikinti olmasidir.
    // @Column(nullable = false)
    @NotNull
    private Boolean deleted = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    public Calendar getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Calendar deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object obj) {

        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (getClass()!=obj.getClass())
            return false;

        AbstractBaseModel other = (AbstractBaseModel) obj;
        if (id==null) {
            if (other.id!=null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
