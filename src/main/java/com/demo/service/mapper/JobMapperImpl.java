package com.demo.service.mapper;

import com.demo.domain.Job;
import com.demo.repository.JobRepository;
import com.demo.service.dto.JobDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T15:29:23+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class JobMapperImpl implements EntityMapper<JobDTO, Job> {

    private final JobRepository jobRepository;

    public JobMapperImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job toEntity(JobDTO dto) {
        if (dto == null) {
            return null;
        }
        Job job = new Job();
        job
            .id(dto.getId())
            .title(dto.getTitle())
            .description(dto.getDescription())
            .location(dto.getLocation())
            .experience(dto.getExperience())
            .salary(dto.getSalary());
        return job;
    }

    @Override
    public JobDTO toDto(Job entity) {
        if (entity == null) {
            return null;
        }
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(entity.getId());
        jobDTO.setDescription(entity.getDescription());
        jobDTO.setExperience(entity.getExperience());
        jobDTO.setTitle(entity.getTitle());
        jobDTO.setLocation(entity.getLocation());
        jobDTO.setSalary(entity.getSalary());
        return jobDTO;
    }

    @Override
    public List<Job> toEntity(List<JobDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Job> jobList = new ArrayList<>();
        for (JobDTO jobDTO : dtoList) {
            jobList.add(toEntity(jobDTO));
        }
        return jobList;
    }

    @Override
    public List<JobDTO> toDto(List<Job> entityList) {
        if (entityList == null) {
            return null;
        }
        List<JobDTO> jobDTOList = new ArrayList<>();
        for (Job jobEntity : entityList) {
            jobDTOList.add(toDto(jobEntity));
        }
        return jobDTOList;
    }

    @Override
    public void partialUpdate(Job entity, JobDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.id(dto.getId());
        }

        if (dto.getDescription() != null) {
            entity.description(dto.getDescription());
        }

        if (dto.getSalary() != null) {
            entity.salary(dto.getSalary());
        }

        if (dto.getTitle() != null) {
            entity.title(dto.getTitle());
        }

        if (dto.getExperience() != null) {
            entity.experience(dto.getExperience());
        }

        if (dto.getLocation() != null) {
            entity.location(dto.getLocation());
        }
    }
}
