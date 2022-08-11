package com.hashnet.temp;

public class Overflow {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println(max+1);
        System.out.println(max+10);


        int min = Integer.MIN_VALUE;
        System.out.println(min);
        System.out.println(min-1);
        System.out.println(min-10);
    }
}
