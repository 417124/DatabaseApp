package com.project.databaseapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_location")
    private String departmentLocation;

    public Department(){}
    public Department(String departmentName, String departmentLocation) {
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }

    // gettery i settery
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!departmentId.equals(that.departmentId)) return false;
        if (!departmentName.equals(that.departmentName)) return false;
        return departmentLocation.equals(that.departmentLocation);
    }

    @Override
    public int hashCode() {
        int result = departmentId.hashCode();
        result = 31 * result + departmentName.hashCode();
        result = 31 * result + departmentLocation.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentLocation='" + departmentLocation + '\'' +
                '}';
    }
}
