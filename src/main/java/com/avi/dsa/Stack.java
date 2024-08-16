package com.avi.dsa;

public class Stack {
    //    static final int MAX = 1000;
    int MAX;
    int top;
    int[] a; // Maximum size of Stack

    boolean isEmpty() {
        return (top < 0);
    }

//    Stack() {
//        top = -1;
//    }

    Stack(int size) {
        top = -1;
        MAX = size;
        a = new int[MAX];
    }

    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top];
            return x;
        }
    }

    void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(" " + a[i]);
        }
    }
}

// Driver code
class Main {
    public static void main(String args[]) {
        Stack s = new Stack(2);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}

