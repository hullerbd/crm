package com.busyqa.crm.pojo.student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "StudentProfile")
public class StudentProfile {
    public StudentProfile() {
    }

    public StudentProfile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public StudentProfile(String firstName, String lastName, List<LearningProfile> learningProfiles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.learningProfiles = learningProfiles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;

    private String firstName;
    private String lastName;

    private String address;

    private String email;
    private String phone1;
    private String phone2;

    //@OneToMany(cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH})//(mappedBy = "studentProfile", fetch = FetchType.EAGER)
    @OneToMany( cascade = CascadeType.ALL)//mappedBy = "studentProfile",
//    @JoinColumn(name = "student_profile_id", referencedColumnName = "id")
    private List<LearningProfile> learningProfiles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public List<LearningProfile> getLearningProfiles() {
        return learningProfiles;
    }

    public void setLearningProfiles(List<LearningProfile> learningProfiles) {
        this.learningProfiles = learningProfiles;
    }
}
