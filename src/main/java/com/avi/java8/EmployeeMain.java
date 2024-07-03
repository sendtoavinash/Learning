package com.avi.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        //////// male and female employees are there in the organization?
        Map<String, Long> maleFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(maleFemaleEmployees);

        ////// name of all departments in the organization?
//        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        ////// average age of male and female employees?
//        Map<String, Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
//        System.out.println(avgAge);

        /////// details of highest paid employee in the organization?
//        Optional<Employee> maxSalary = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
//        System.out.println(maxSalary);

        /////// names of all employees who have joined after 2015?
//        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

        /////// number of employees in each department?
//        Map<String, Long> empByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//        empByDepartment.entrySet().stream().forEach(System.out::println);

        /////// average salary of each department?
//        Map<String, Double> avgSalaryByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
//        avgSalaryByDepartment.entrySet().stream().forEach(System.out::println);

        /////// youngest male employee in the product development department?

//        Optional<Employee> youngestMale = employeeList.stream().filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development").min(Comparator.comparingInt(Employee::getAge));
//        youngestMale.ifPresent(System.out::println);

        //////// most working experience in the organization?
//        Optional<Employee> mostExperience = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
//        mostExperience.ifPresent(System.out::println);

        ////////  male and female employees are there in the sales and marketing team?
//        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream().filter(e -> e.getDepartment() == "Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        countMaleFemaleEmployeesInSalesMarketing.entrySet().forEach(System.out::println);

        /////// average salary of male and female employees?
//        Map<String, Double> avgSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
//        System.out.println(avgSalary);

        ///////  List down the names of all employees in each department?
//        Map<String, List<Employee>> empEachDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//        Set<Map.Entry<String, List<Employee>>> empEachDepartmentSet = empEachDepartment.entrySet();
//        empEachDepartmentSet.forEach(System.out::println);

        /////// average salary and total salary of the whole organization?
//        DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
//        System.out.println("Average salary " + employeeSalaryStatistics.getAverage());
//        System.out.println("Total Salary " + employeeSalaryStatistics.getSum());


        /////// compare age then name
////        employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).thenComparing(Employee::getName);
//
//          Comparator<Employee> employee_Age_Name_Comparator
//                = Comparator.comparing(Employee::getAge)
//                .thenComparing(Employee::getName);

        ////////// Average Salary of employee greater than 25 years old
//        System.out.println(employeeList.stream().filter(i->i.getAge()>25).collect(Collectors.averagingDouble(Employee::getSalary)));

        ////////// sort employee on the bases of names
        employeeList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);


    }
}
