package RESTAPI.example.RESTAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Employee {
    private Long employeeID;
    private String name;
    private Double salary;

    public Employee(Long employeeID, String name, Double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
