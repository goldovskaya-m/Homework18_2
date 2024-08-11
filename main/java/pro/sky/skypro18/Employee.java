package pro.sky.skypro18;

import java.util.Objects;

public class Employee {
    private final int id;
    private static int idCounter;
    private String lastName;
    private String firstName;

    public Employee(int id,String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = ++idCounter;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public static void setIdCounter(int idCounter) {
        Employee.idCounter = idCounter;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getAllFields() {
        return " ФИО " + lastName + firstName;

    }

    @Override
    public String toString() {
        return String.format(" ФИО " + lastName + firstName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return firstName.equals(employee.firstName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

