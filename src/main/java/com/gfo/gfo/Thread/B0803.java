package com.gfo.gfo.Thread;

public class B0803 {
    public static void main(String[] args) {
        int i;
        int num = 1020;
        for (i = 1; ; i++) {
            num=num-(num/2+2);
            System.err.println("第"+i+"后剩下"+num+"个");
            if (num == 0) {
                break;
            }
        }
            System.out.println(i+"天卖完");
    }
}
