package com.example.javaexample;

import java.util.ArrayList;

public class JavaExample3 {

    public static void multipleTwoArrayLists(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<a.size(); i++) {
            result.add(a.get(i)*b.get(i));
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        ArrayList<Integer> ints1 = new ArrayList<>();
        ArrayList<Integer> ints2 = new ArrayList<>();
        for (int i=0; i < 10; i++) {
            ints1.add(i);
        }
        System.out.println(ints1);
        for (int i=9; i>=0; i--) {
            ints2.add(i);
        }
        System.out.println(ints2);
        multipleTwoArrayLists(ints1,ints2);
    }
}
