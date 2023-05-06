package com.demo.service.dto;

import com.google.common.base.Objects;
import java.io.SequenceInputStream;
import java.io.Serializable;

@SuppressWarnings("common-java:DuplicatedBlocks")
public class JobDTO implements Serializable {

    private Long id;
    private String title;
    private String description;
    private String location;
    private Integer experience;
    private Double salary;

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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobDTO)) return false;
        JobDTO jobDTO = (JobDTO) o;
        return id != null && Objects.equal(id, jobDTO.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
