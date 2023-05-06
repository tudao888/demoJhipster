package com.demo.service;

import com.demo.domain.Job;
import com.demo.service.dto.JobDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {
    JobDTO save(JobDTO jobDTO);
    JobDTO update(JobDTO jobDTO);
    Page<JobDTO> findAll(Pageable pageable);
    Optional<JobDTO> partialUpdate(JobDTO jobDTO);
    Optional<JobDTO> findOne(Long id);
    void delete(Long id);
}
