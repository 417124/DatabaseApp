package com.project.databaseapp.repository;

import com.project.databaseapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
 // operacje CRUD
    Employee findByEmployeeId(Long employeeId); //select
    List<Employee> findByDeviceIsNotNull(); // inner join z Devices
    List<Employee> findAllBy(); //left join z devices
    List<Employee> findByDepartmentIsNotNull(); //inner join z Departments

}
