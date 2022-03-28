package com.blazecode.departmentservice.repository;

import com.blazecode.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
// always an interface
//extends JpaRepository<EntityType, PrimaryKeyIdDataType>

    Department findByDepartmentId(Long departmentId);

}