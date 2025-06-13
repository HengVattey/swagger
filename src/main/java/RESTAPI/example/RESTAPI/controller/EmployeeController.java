package RESTAPI.example.RESTAPI.controller;

import RESTAPI.example.RESTAPI.model.entity.Employee;
import RESTAPI.example.RESTAPI.model.request.EmployeeRequest;
import ch.qos.logback.core.model.conditional.ElseModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private final  static List<Employee> EMPLOYEE_LIST=new ArrayList<>();
    private  final  static AtomicLong ATOMIC_LONG =new AtomicLong(3L);

    public EmployeeController(){
        EMPLOYEE_LIST.add(new Employee(1L,"Vattey",200000.0));
        EMPLOYEE_LIST.add(new Employee(2L,"Cute",500.0));
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return EMPLOYEE_LIST;
    }

    @PostMapping
    public  Employee saveEmployee(@RequestBody EmployeeRequest request){
           Employee employee=new Employee(ATOMIC_LONG.getAndIncrement(), request.getName(), request.getSalary());
           EMPLOYEE_LIST.add(employee);
        return employee;

    }
    @GetMapping("/{employee-id}")
    public  Employee getEmployeeID(@PathVariable("employee-id") Long employeeId){
        for (Employee employee: EMPLOYEE_LIST){
            if (employee.getEmployeeID().equals(employeeId)  )
                return  employee;
        }
        return null;
    }

    @PutMapping("/{employee-id}")
    public Employee updateEmployeeById(@PathVariable("employee-id") Long employeeId,
                                       @RequestBody EmployeeRequest Request){
        for(Employee employee: EMPLOYEE_LIST){
            if(employee.getEmployeeID().equals(employeeId)){
                employee.setName(Request.getName());
                employee.setSalary(Request.getSalary());
                return employee;
            }
        }
        return  null;


    }
    @DeleteMapping("/{employee-id}")
    public  String deleEmployeeId(@PathVariable("employee-id") Long employeeId){
        for (Employee employee : EMPLOYEE_LIST){
            if (employee.getEmployeeID().equals(employeeId)){
                EMPLOYEE_LIST.remove(employee);
                return "Delect employee successful!";
            }
        }
        return null;
    }
    @GetMapping("/search")
    public  List<Employee> searchEmployeeByName(@RequestParam String name ){
        List<Employee> employees=new ArrayList<>();
        for (Employee employee: EMPLOYEE_LIST){
            if (employee.getName().toLowerCase().contains(name.toLowerCase())){
                employees.add(employee);

            }
        }

        return employees;
    }



}
