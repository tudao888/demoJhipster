package com.demo.service;

import com.demo.service.dto.BlogDTO;
import com.demo.service.dto.EmployeeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    Page<EmployeeDTO> findAll(Pageable pageable);
    Optional<EmployeeDTO> partialUpdate(EmployeeDTO employeeDTO);
    Optional<EmployeeDTO> findOne(Long id);
    void delete(Long id);
}
