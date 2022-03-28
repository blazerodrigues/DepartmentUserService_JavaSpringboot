package com.blazecode.departmentservice.service;

import com.blazecode.departmentservice.entity.Department;
import com.blazecode.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){

        log.info("Inside saveDepartment method of Department Service");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId){
        log.info("Inside findByDepartmentId method of Department Service");
        return departmentRepository.findByDepartmentId(departmentId);
    }

}
