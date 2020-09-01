package com.gfo.gfo.Thread;

public class C0803 {
    private static final int SIZE = 1000;
    public static void main(String[] args) {
        int[] data =new int[SIZE];
        int i;
        for (i=0; i < data.length; i++) {
            data[i]=i+1;
        }
        data[999]=567;
        System.err.println(i);
        System.err.println(data[999]);
        result(data);

    }

    private static void result(int[] data) {

    }
}
