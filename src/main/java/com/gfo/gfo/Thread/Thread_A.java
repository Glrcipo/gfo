package com.gfo.gfo.Thread;

public class Thread_A {
    private  static int a=0;
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            a += 1;
        });
        Thread thread1 = new Thread(() -> {
            a -= 1;
        });
        thread.start();
        thread1.start();

//        thread.start();  Thread创建的线程是不能重复执行
    }
}
