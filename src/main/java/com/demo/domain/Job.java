package com.demo.domain;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "job")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "type")
    private JobType type;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "post_date")
    private Instant postDate;

    @Column(name = "expiration_date")
    private Instant expirationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Job id(Long id) {
        this.setId(id);
        return this;
    }

    public Job title(String title) {
        this.setTitle(title);
        return this;
    }

    public Job() {}

    public Job description(String description) {
        this.setDescription(description);
        return this;
    }

    public Job location(String location) {
        this.setLocation(location);
        return this;
    }

    public Job type(JobType type) {
        this.setType(type);
        return this;
    }

    public Job salary(Double salary) {
        this.setSalary(salary);
        return this;
    }

    public Job experience(Integer experience) {
        this.setExperience(experience);
        return this;
    }

    public Job postDate(Instant postDate) {
        this.setPostDate(postDate);
        return this;
    }

    public Job expirationDate(Instant expirationDate) {
        this.setExpirationDate(expirationDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        //        return Objects.equal(id, job.id) && Objects.equal(title, job.title) && Objects.equal(description, job.description) && Objects.equal(location, job.location) && type == job.type && Objects.equal(salary, job.salary) && Objects.equal(experience, job.experience) && Objects.equal(postDate, job.postDate) && Objects.equal(expirationDate, job.expirationDate);
        return id != null && id.equals(job.getId());
    }

    @Override
    public int hashCode() {
        //        return Objects.hashCode(id, title, description, location, type, salary, experience, postDate, expirationDate);
        return getClass().hashCode();
    }
}
