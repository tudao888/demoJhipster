package com.demo.service.mapper;

import com.demo.domain.Employee;
import com.demo.service.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {}
