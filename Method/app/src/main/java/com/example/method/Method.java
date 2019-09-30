package com.example.method;

public class Method {
    public int plus(int a, int b) {
        int result;
        result = a + b;
        return result;
    }

    public void plus1(int a, int b) {
        int result;
        result = a + b;
    }

    public static void main(String[] args) {
        new Method().plus(1,2);
        new Method().plus1(10,20);

        int number1;
        int number2;

        number1 = new Method().plus(100, 100);
        number2 = new Method().plus(50,50);

        System.out.println(number1);
        System.out.println(number2);
    }
}
