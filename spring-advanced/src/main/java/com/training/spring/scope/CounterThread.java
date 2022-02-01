package com.training.spring.scope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class CounterThread extends Thread {

    private static final int     THREAD_COUNT = 3;

    public static long           counter;
    public static AtomicLong     counterLong  = new AtomicLong();

    private final CountDownLatch cdl;
    private final List<String>   strings      = Collections.synchronizedList(new ArrayList<>());

    public static void increase() {
        CounterThread.counterLong.incrementAndGet();
        //        synchronized (CounterThread.class) {
        //            CounterThread.counter++;
        //        }
    }


    public CounterThread(final CountDownLatch cdlParam) {
        super();
        this.cdl = cdlParam;
    }

    @Override
    public void run() {
        for (int iLoc = 0; iLoc < 100_000_000; iLoc++) {
            increase();
            // CounterThread.counter++;
        }
        this.cdl.countDown();
    }

    public static void main(final String[] args) {
        CountDownLatch cdl = new CountDownLatch(CounterThread.THREAD_COUNT);
        for (int iLoc = 0; iLoc < CounterThread.THREAD_COUNT; iLoc++) {
            CounterThread counterThreadLoc = new CounterThread(cdl);
            counterThreadLoc.start();
        }
        try {
            cdl.await();
            System.out.println("Counter : " + CounterThread.counter);
            System.out.println("Counter 2 : " + CounterThread.counterLong.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
