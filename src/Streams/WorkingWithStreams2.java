package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingWithStreams2 {


    public static void main(String[] args) {

        Employee justin = new Employee(101, "Justin", "Canada", 27);
        Employee zayn = new Employee(102, "Zayn", "UK", 15);
        Employee drake = new Employee(103, "Drake", "USA", 10);

        List<Employee> youngPeople = new ArrayList<Employee>();
        //List<Employee> youngPeople2 = new ArrayList<>();

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(justin);
        employees.add(zayn);
        employees.add(drake);

        for(Employee person : employees) {
            if(person.getAge() <= 18 ) {
                youngPeople.add(person);
            }
        }

        System.out.println(youngPeople);

        // With Streams
        List<Employee> youngPeople2 = employees.stream()
                .filter(person -> person.getAge() <= 18)
                .collect(Collectors.toList());

        youngPeople2.forEach(System.out::println);

        System.out.println("Filter...");
        // Filter
        List<Employee> filterEmployee = employees.stream()
                .filter(employee -> employee.getAge() > 18 )
                .filter(employee -> employee.getName().equals("Justin"))
                .collect(Collectors.toList());
        filterEmployee.forEach(System.out::println);

        // Transformation
        System.out.println("Transformation...");
        List<EmployeeTransformations> employeeTrans = employees.stream()
                .map(employee -> {
                    EmployeeTransformations employeeTransformations = new EmployeeTransformations(
                            employee.getId(), employee.getName(), employee.getAge());
                    return employeeTransformations;
                })
                .collect(Collectors.toList());
        employeeTrans.forEach(System.out::println);
//        System.out.println(System.nanoTime());
    }
}
