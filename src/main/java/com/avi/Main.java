package com.avi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Runnable myThread = () -> {
            System.out.println("My Thread");
        };

        Thread th = new Thread(myThread);
        th.start();

        List<Person> p = new ArrayList<>();

        p.add(new Person("Avinash", 29));
        p.add(new Person("Ritesh", 30));
        p.add(new Person("Prashnt", 35));
        p.add(new Person("Ravi", 36));


//        List<Person> ls = p.stream().sorted(Comparator.reverseOrder()).toList();

        List<Person> l = p.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).toList();

/*
        EmployeeInfo[EmpId, EmpFname, EmpLname, Department, Project, Address, DOB, Gender]
        EmployeePosition[EmpId, EmpPosition, DateOfJoining, salary]
        1. Write a query to retrieve Departments who have less than 2 employees working in it.
        2. Write a query to find the third - highest salary from the EmpPosition table.

        select emp.department from employeeinfo emp where emp.department < 2

        select em.salary from employeePosition em oder by salary limit 1 offset 2
*/

    }
}
