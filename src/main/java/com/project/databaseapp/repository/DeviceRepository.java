package com.project.databaseapp.repository;

import com.project.databaseapp.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{
    // operacje CRUD
    Device findByDeviceId(Long deviceId); // select

    List<Device> findByEmployeeIsNotNull(); // inner join z Employees

    List<Device> findAllBy(); // left join z Employees
}
