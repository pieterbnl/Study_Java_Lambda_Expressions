package com.pbe;

public class LambdaDemo {

    public static void main(String[] args) {

        // Declare an interface reference
        MyNum myNum;

        // Lambda expression as simple constant expression, assigned to myNum
        // This will trigger a class instance to be constructed
        // In which the lambda expression implements the MyNum getValue() method
        myNum = () -> 12345.678;

        // call getValue()
        System.out.println("Fixed value: " + myNum.getValue());

        // Another lambda expression
        myNum = () -> Math.random() * 2;
        System.out.println("A random value: " + myNum.getValue());
        System.out.println("Another random value: " + myNum.getValue());

        // This won't work.
        // A lambda expression must be compatible with the method defined by the functional interface.
        // myNum = () -> "1234.567"; // bad return type: a double value is expected, not a String value

    }
}