package com.gfo.gfo.Thread;

/**
 * 线程创建
 */
public class RunnableThread {
    private static volatile Integer J=0;
    public static void main(String[] args) {
        /**
         * Runnable创建的线程是可重复执行
         */
        Runnable r =()->{
          J+=1;
            System.err.println(J);
        };
        Runnable g =()->{
            J-=1;
            System.err.println(J);
        };
       new Thread(r).start();
       new Thread(g).start();
       new Thread(r).start();
       new Thread(g).start();

    }

}
