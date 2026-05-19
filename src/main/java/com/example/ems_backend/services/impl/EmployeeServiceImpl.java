package com.example.ems_backend.services.impl;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //to inject employeeRepo as a dependency using constructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //and within this create employee method first we need to convert employee dto into employee JP entity because we need
        //to store the employee entity into database
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        //next let us save this employee JP entity into database
        Employee savedEmployee = employeeRepository.save(employee);
        //convert the jpa entity back to dto and return to client
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    //then we will create the method to create employee
}
