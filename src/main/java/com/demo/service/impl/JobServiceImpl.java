package com.demo.service.impl;

import com.demo.domain.Job;
import com.demo.repository.JobRepository;
import com.demo.service.JobService;
import com.demo.service.dto.JobDTO;
import com.demo.service.mapper.JobMapperImpl;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    private final Logger log = LoggerFactory.getLogger(JobService.class);

    private final JobRepository jobRepository;
    private final JobMapperImpl jobMapper;

    public JobServiceImpl(JobRepository jobRepository, JobMapperImpl jobMapper) {
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
    }

    @Override
    public JobDTO save(JobDTO jobDTO) {
        log.debug("Request to save Job : {}", jobDTO);
        Job job = jobMapper.toEntity(jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    @Override
    public JobDTO update(JobDTO jobDTO) {
        log.debug("Request to update Job : {}", jobDTO);
        Job job = jobMapper.toEntity(jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    @Override
    public Page<JobDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Jobs");
        return jobRepository.findAll(pageable).map(jobMapper::toDto);
    }

    @Override
    public Optional<JobDTO> partialUpdate(JobDTO jobDTO) {
        log.debug("Request to partially update Job : {}", jobDTO);
        Optional<Job> existingJob = jobRepository.findById(jobDTO.getId());

        if (existingJob.isPresent()) {
            jobMapper.partialUpdate(existingJob.get(), jobDTO);
            Job updatedJob = jobRepository.save(existingJob.get());

            return Optional.of(jobMapper.toDto(updatedJob));
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<JobDTO> findOne(Long id) {
        log.debug("Request to get a Job : {}", id);
        return jobRepository.findById(id).map(jobMapper::toDto);
        //        Optional<Job> job = jobRepository.findById(id);
        //        if (job.isPresent()) {
        //            JobDTO jobDTO = jobMapper.toDto(job.get());
        //            return Optional.of(jobDTO);
        //        } else {
        //            return Optional.empty();
        //        }
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Job : {}", id);
        jobRepository.deleteById(id);
    }
}
