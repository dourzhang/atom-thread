package com.watent.thread.base.bq.lockbq;

import java.util.LinkedList;
import java.util.List;

/**
 * 有界阻塞队列
 */
public class BlockingQueueWN<T> {

    private List<T> queue = new LinkedList<>();
    private final int limit;

    public BlockingQueueWN(int limit) {
        this.limit = limit;
    }

    //入队
    public synchronized void enqueue(T item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        //将数据入队，可以肯定有出队的线程正在等待
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    //出队
    public synchronized T dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
}
