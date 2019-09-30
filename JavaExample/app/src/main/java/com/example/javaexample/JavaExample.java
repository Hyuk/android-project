package com.example.javaexample;

import java.util.ArrayList;

public class JavaExample {

    public static void main(String[] args) {
        ArrayList<Integer> ints1 = new ArrayList<>();
        ArrayList ints2 = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            ints1.add(i);
        }
//        System.out.println(ints1);

        for (int i = 0; i < ints1.size(); i++) {
            if(ints1.get(i)<5) {
                ints2.add(true);
            } else {
                ints2.add(false);
            }
        }
        System.out.println(ints2);
    }
}
