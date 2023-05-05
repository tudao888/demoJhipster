package com.demo.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "employee")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "grade")
    private String grade;

    @Column(name = "gender")
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee id(Long id) {
        this.setId(id);
        return this;
    }

    public Employee name(String name) {
        this.setName(name);
        return this;
    }

    public Employee age(Integer age) {
        this.setAge(age);
        return this;
    }

    public Employee grade(String grade) {
        this.setGrade(grade);
        return this;
    }

    public Employee gender(String gender) {
        this.setGrade(gender);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        //        Employee employee = (Employee) o;
        //        return getId().equals(employee.getId()) && getName().equals(employee.getName()) && getAge().equals(employee.getAge()) && getGrade().equals(employee.getGrade()) && getGender().equals(employee.getGender());
        return id != null && id.equals(((Blog) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
