package com.exam.Manytodemo.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by melayer on 7/10/17.
 */
@Entity
public class Student {


    @Id
    Integer student_id;
    String Student_name;
    String Student_city;

    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }

    @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "joined_tab",joinColumns=@JoinColumn(name = "student_id",referencedColumnName = "student_id"),inverseJoinColumns = @JoinColumn(name = "subject_id",referencedColumnName = "subject_id"))
    Set<Subject> subject;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public void setStudent_name(String student_name) {
        Student_name = student_name;
    }

    public String getStudent_city() {
        return Student_city;
    }

    public void setStudent_city(String student_city) {
        Student_city = student_city;
    }



    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", Student_name='" + Student_name + '\'' +
                ", Student_city='" + Student_city + '\'' +
                '}';
    }


}
