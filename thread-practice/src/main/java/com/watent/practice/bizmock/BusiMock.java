package com.watent.practice.bizmock;

/**
 * 用sleep模拟实际的业务操作
 */
public class BusiMock {

    public static void business(Integer sleepTime) {

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
