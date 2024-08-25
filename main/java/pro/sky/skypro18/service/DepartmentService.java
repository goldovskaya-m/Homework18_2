package pro.sky.skypro18.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.skypro18.Employee;
import pro.sky.skypro18.controller.DepartmentController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Locale.filter;
import static org.apache.logging.log4j.ThreadContext.peek;


@Service

public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // @GetMapping("/max-salary")
    //public void getMaxSalaryEmployee(@RequestParam("departmentId") int departmentId) {
    public Employee getMaxSalaryEmployee(int departmentId) {
        // for (int i = 0; i < employeeService.findAll().size(); i++) {
        //}
        //Collection<Employee> List = employeeService.findAll();
        // List.add(new Employee("Олег", "Олегович"));
        // List.add(new Employee("Олег", "Олегович"));
        // List.add(new Employee("Олег", "Олегович"));
        //        List<Employee> collect = List.stream()
        //employeeService.findAll().stream()  //Employee1 - Employee2 - Employee3 - Employee3 -
        //       .peek(new TestPeek())
        //       .collect(Collectors.toList());
        return employeeService.findAll().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();

    }

    // @GetMapping("/min-salary")
    //public void getMinSalaryEmployee(@RequestParam("departmentId") int departmentId) {
    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.findAll().stream()
        .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();


    }

    // @GetMapping("/all/dy-department")
    //public void getAllEmployeeDepartment(@RequestParam("departmentId") int departmentId) {
    public List<Employee> getAllEmployeeDepartment(int departmentId) {
        Stream.iterate(0, x -> x + 1).forEach(System.out::println);

        return employeeService.findAll().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());


    }

    // @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.findAll().stream().collect(Collectors.groupingBy
                (Employee::getDepartmentId));

    }

    //public class TestPeek implements Consumer<Employee> {

    //  @Override
    //  public void accept(Employee employee) {

    //  }
    // }
}
