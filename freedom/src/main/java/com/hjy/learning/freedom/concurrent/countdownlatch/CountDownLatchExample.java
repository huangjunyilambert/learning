package com.hjy.learning.freedom.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by huangjy on 2019/7/25.
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        CountDownLatchService service = new CountDownLatchService(latch);
        Runnable task = () -> service.exec();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        System.out.println("main thread await. ");
        latch.await();
        System.out.println("main thread finishes await. ");
    }
}
