package RESTAPI.example.RESTAPI.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long employeeID;
    private String name;
    private Double salary;

}
