package tr.org.lkd.lyk2015.camp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * This entity represents an application form which is submitted by a Student.
 * <p/>
 * Same student may submit different forms in different years.
 */
@Entity
public class Application extends AbstractBaseModel {

    @Max(2005)
    @Min(1940)
    private Integer year;

    @Enumerated(EnumType.STRING)
    private WorkStatus workStatus;

    private Boolean officer = false;

    private String corporation;

    private String workDetails;

    private Integer englishLevel = 0;

    private String githubLink;

    private String uuid;

    private Boolean validated = false;

    @ManyToMany
    private Set<Course> preferredCourses = new HashSet<>();

    @ManyToOne
    private Student owner;

    private boolean needAccomodation = false;

    private boolean selected = false;

    public boolean isSelected() {
        return selected;
    }

    public void setIsSelected(boolean isSelected) {
        this.selected = isSelected;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }

    public WorkStatus getWorokStatus() {
        return workStatus;
    }

    public boolean isOfficer() {
        return officer;
    }

    public void setOfficer(boolean officer) {
        this.officer = officer;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getWorkDetails() {
        return workDetails;
    }

    public void setWorkDetails(String workDetails) {
        this.workDetails = workDetails;
    }

    public int getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(int englishLevel) {
        this.englishLevel = englishLevel;
    }

    public void setEnglishLevel(Integer englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public Set<Course> getPreferredCourses() {
        return preferredCourses;
    }

    public void setPreferredCourses(Set<Course> preferredCourses) {
        this.preferredCourses = preferredCourses;
    }

    public boolean isNeedAccomodation() {
        return needAccomodation;
    }

    public void setNeedAccomodation(boolean needAccomodation) {
        this.needAccomodation = needAccomodation;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getOfficer() {
        return officer;
    }

    public void setOfficer(Boolean officer) {
        this.officer = officer;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public enum WorkStatus {
        WORKING, STUDENT, NOT_WORKING
    }
}