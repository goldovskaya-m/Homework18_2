package pro.sky.skypro18;

import org.springframework.stereotype.Service;
import pro.sky.skypro18.exception.EmployeeNotFoundException;
import pro.sky.skypro18.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //private final List<Employee> employeeList;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        //this.employeeList = new ArrayList<>();
        this.employees = new HashMap<>();

    }

    @Override
    //public Employee add(String firstName, String lastName) {
    //   Employee employee = new Employee(firstName, lastName);
    //  if (employeeList.contains(employee)) {
    //      throw new EmployeeAlreadyAddedException();
    // }
    //  employeeList.add(employee);
    //  return null;
    // }
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }


    @Override
    //public Employee remove(String firstName, String lastName) {
    //  Employee employee = new Employee(firstName, lastName);
    // if (employeeList.contains(employee)) {
    //    employeeList.remove(employee);
    //   return employee;
    //}
    // throw new EmployeeNotFoundException();
    //}
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            // employees.remove(employee.getFullName());
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    //public Employee find(String firstName, String lastName) {
    //  Employee employee = new Employee(firstName, lastName);
    // if (employeeList.contains(employee)) {
    //     return employee;
    //}
    //throw new EmployeeNotFoundException();
    //}
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    @Override

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    //  @Override
    // public Collection<Employee> findAll() {
    //      return new ArrayList<>(employeeList);
    //  }

    //@Override
    //public Collection<Employee> findAll() {
    //    return employeeList;
    // }

}

