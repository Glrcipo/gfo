package com.gfo.gfo.Thread;

import java.util.concurrent.Callable;

public class CallableThread {
    private  static int a=0;
    public static void main(String[] args) throws Exception {
        /**
         * Callable创建的线程是可以重复执行
         */
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                a+=1;
                return a;
            }
        };
        Callable callab = new Callable() {
            @Override
            public Object call() throws Exception {
                a-=1;
                return a;
            }
        };
        callable.call();
        callab.call();

        callab.call();

        System.err.println( callable.call());
        System.err.println(  callab.call());
    }
}
