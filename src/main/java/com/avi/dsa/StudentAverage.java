package com.avi.dsa;

import java.util.HashMap;
import java.util.Map;

public class StudentAverage {

    public static void main(String[] args) {
        String input = "Rakesh=20,Mukesh=10,Anu=10,Vikram=30,sachin=50,Mukesh=30,Anu=100,Vikram=90,Rakesh=30,Kishan=10,Sumit=5,Abhay=20,Rajesh=8,Sumit=30,Rajesh=100,Vikram=30,sachin=50,Mukesh=30,Anu=100,Vikram=90,Rakesh=30,Kishan=10";
        String[] arr = input.split(",");

        Map<String, int[]> studentData = new HashMap<>();

        for (String entry : arr) {
            String[] individual = entry.split("=");
            String name = individual[0];
            int marks = Integer.parseInt(individual[1]);

            studentData.putIfAbsent(name, new int[2]); // Initialize if not present
            studentData.get(name)[0] += marks; // Sum of marks
            studentData.get(name)[1] += 1;     // Count of entries
        }

        for (Map.Entry<String, int[]> entry : studentData.entrySet()) {
            String name = entry.getKey();
            int totalMarks = entry.getValue()[0];
            int count = entry.getValue()[1];
            int avg = totalMarks / count;
            System.out.println("Average marks for " + name + ": " + avg);
        }
    }
}
