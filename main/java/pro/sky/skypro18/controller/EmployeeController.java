package pro.sky.skypro18.controller;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro18.exception.InvalidNameException;
import pro.sky.skypro18.model.Employee;
import pro.sky.skypro18.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController{
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        validateNames(firstName, lastName);
        return service.add(firstName, lastName);
    }

    private void validateNames(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName)){
            throw new InvalidNameException(firstName);
        }
        if (!StringUtils.isAlpha(lastName)){
            throw new InvalidNameException(lastName);
        }
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        validateNames(firstName, lastName);
        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        validateNames(firstName, lastName);
        return service.find(firstName, lastName);
    }
    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
