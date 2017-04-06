package pl.com.kubachmielowiec.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private JobPosition jobPosition;

    private String firstName;
    private String surname;
    private String email;
    private String description;

    private File cv;

    private String ipAddres;

    JobApplication(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getCv() {
        return cv;
    }

    public void setCv(File cv) {
        this.cv = cv;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setIpAddress(String ipAddres) {
        this.ipAddres = ipAddres;
    }
}
