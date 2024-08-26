package leet_code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int salary;
    private String name;

    public Employee(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SortedEmployees implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getSalary()>o2.getSalary())
            return 1;
        if(o1.getSalary()==o2.getSalary())
            return 0;
        else
            return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

public class _23_SortEmployees {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Aditya1", 100));
        employees.add(new Employee("Aditya2", 500));
        employees.add(new Employee("Aditya3", 2050));
        employees.add(new Employee("Aditya4", 10));
        employees.add(new Employee("Aditya5", 150));
        employees.add(new Employee("Aditya6", 160));
        employees.add(new Employee("Aditya7", 120));


        SortedEmployees s= new SortedEmployees();
        employees.sort(s);
        employees.forEach(emp -> System.out.println(emp.getName() + ", salary: "+emp.getSalary()));
    }

}
