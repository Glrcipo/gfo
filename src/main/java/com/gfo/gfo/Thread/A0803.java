package com.gfo.gfo.Thread;

public class A0803 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 100*3 ; i+=3) {
            for (int j = 0; j < 100/3; j++) {
                for (int k = 0; k < 100/5; k++) {
                    if (i/3+j*3+k*5==100 && i+j+k==100) {
                        count++;
                        System.err.println("小："+i+"；公："+j+"；母："+k);
                    }
                }
            }
        }
        System.out.println("共："+count+"中买法。");


    }
}
