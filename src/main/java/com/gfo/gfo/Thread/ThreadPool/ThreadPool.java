package com.gfo.gfo.Thread.ThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 运用Executors创建线程线程池有四种方式
 */
public final class ThreadPool {

    /**
     * newFixedThreadPool
     * 定长线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量，这时线程数量不再变化，当线程发生错误结束时，线程池会补充一个新的线程
     **/
    static ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
    //测试定长线程池，线程池的容量为3，提交6个任务，根据打印结果可以看出先执行前3个任务，3个任务结束后再执行后面的任务
    static void testFixedExecutor() {
        for (int i = 0; i < 6; i++) {
            final int index = i;
            fixedExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " index:" + index);
                }
            });
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");

        fixedExecutor.shutdown();
    }

    /**
     * newCachedThreadPool
     * 可缓存的线程池，如果线程池的容量超过了任务数，自动回收空闲线程，任务增加时可以自动添加新线程，线程池的容量不限制
     */
    static ExecutorService cachedExecutor = Executors.newCachedThreadPool();

    //测试可缓存线程池
    static void testCachedExecutor() {
        for (int i = 0; i < 6; i++) {
            final int index = i;
            cachedExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " index:" + index);
                }
            });
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");
        cachedExecutor.shutdown();
    }

    /**
     * newSingleThreadExecutor
     * 定长线程池，可执行周期性的任务
     */
    static ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);

    //测试定长、可周期执行的线程池
    static void testScheduledExecutor() {
        for (int i = 0; i < 3; i++) {
            final int index = i;
            //scheduleWithFixedDelay 固定的延迟时间执行任务； scheduleAtFixedRate 固定的频率执行任务
            scheduledExecutor.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " index:" + index);
                }
            }, 0, 3, TimeUnit.SECONDS);
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");

        scheduledExecutor.shutdown();
    }


    /**
     * newSingleThreadExecutor
     * 单线程的线程池，线程异常结束，会创建一个新的线程，能确保任务按提交顺序执行
     */
    static ExecutorService singleExecutor = Executors.newSingleThreadExecutor();

    //测试单线程的线程池
    static void testSingleExecutor() {
        for (int i = 0; i < 3; i++) {
            final int index = i;
            singleExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " index:" + index);
                }
            });
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");
        singleExecutor.shutdown();
    }

    /**
     * newSingleThreadScheduledExecutor
     * 单线程可执行周期性任务的线程池
     */
        static ScheduledExecutorService singleScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        //测试单线程可周期执行的线程池
        static void testSingleScheduledExecutor() {
            for (int i = 0; i < 3; i++) {
                final int index = i;
                //scheduleWithFixedDelay 固定的延迟时间执行任务； scheduleAtFixedRate 固定的频率执行任务
                singleScheduledExecutor.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " index:" + index);
                    }
                }, 0, 3, TimeUnit.SECONDS);
            }

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4秒后...");

            singleScheduledExecutor.shutdown();
        }


    /**
     * newWorkStealingPool
     * 任务窃取线程池
     */
        static ExecutorService workStealingExecutor = Executors.newWorkStealingPool();
        //测试任务窃取线程池
        static void testWorkStealingExecutor() {
            for (int i = 0; i < 10; i++) {//本机 CPU 8核，这里创建10个任务进行测试
                final int index = i;
                workStealingExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " index:" + index);
                    }
                });
            }

            try {
                Thread.sleep(4000);//这里主线程不休眠，不会有打印输出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4秒后...");

		workStealingExecutor.shutdown();
        }




}
