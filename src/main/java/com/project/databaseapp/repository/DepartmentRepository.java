package com.project.databaseapp.repository;

import com.project.databaseapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    //operacje CRUD
    Department findByDepartmentId(Long departmentId);  // select
}
