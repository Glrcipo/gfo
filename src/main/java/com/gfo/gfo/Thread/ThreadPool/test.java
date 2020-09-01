package com.gfo.gfo.Thread.ThreadPool;

public class test {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        threadPool.testFixedExecutor();
        threadPool.testCachedExecutor();
        threadPool.testScheduledExecutor();
        threadPool.testSingleExecutor();
        threadPool.testSingleScheduledExecutor();
        threadPool.testWorkStealingExecutor();
    }

}
