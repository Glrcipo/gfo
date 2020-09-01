package com.gfo.gfo.Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_Local {
    private static ThreadLocal<SimpleDateFormat>t1 = new ThreadLocal<>();
    private static final SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static ReentrantLock lock = new ReentrantLock();
    
    public static class ParseDate implements Runnable{
        int i =0;

        public ParseDate(int i) {
            this.i = i;
        }
        

        @Override
        public void run() {
            if (t1.get()==null)
                t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            try {
                Date date = t1.get().parse("2020-8-1 09:00"+i+"");
                System.err.println(i+"--"+date);
                Thread.sleep(10);
            }catch (ParseException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
