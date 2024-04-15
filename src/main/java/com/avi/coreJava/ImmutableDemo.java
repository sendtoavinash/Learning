package com.avi.coreJava;

final class EmployeeImmutable {
    final String pancardNumber;

    public EmployeeImmutable(String pancardNumber) {
        this.pancardNumber = pancardNumber;
    }

    public String getPancardNumber() {
        return pancardNumber;
    }
}

public class ImmutableDemo {
    public static void main(String ar[]) {
        EmployeeImmutable e = new EmployeeImmutable("ABC123");
        String s1 = e.getPancardNumber();
        System.out.println("Pancard Number: " + s1);
    }
}