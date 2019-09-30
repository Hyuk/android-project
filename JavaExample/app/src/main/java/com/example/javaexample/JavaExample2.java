package com.example.javaexample;

import java.util.ArrayList;

public class JavaExample2 {

    public static int howManyOdds(ArrayList<Integer> a) {
        int count = 0;
        for(int i=0; i<a.size(); i++) {
            if(a.get(i)%2 != 0) {
                count = count+1;
            } else {
                count = count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints1 = new ArrayList<>();
        int count = 0;
        for (int i=0; i<=9; i++){
            ints1.add(i);
        }

        System.out.println(howManyOdds(ints1));
    }
}
