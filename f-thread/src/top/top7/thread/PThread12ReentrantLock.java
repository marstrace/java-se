package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/9 11:57.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用java.util.concurrent.locks.Reentrantlock实现线程同步机制及生产者与消费者模式
 * //使用reentrantLock的newCondition方法获取Condition实例
 * //使用Condition的await()与single() singleAll()方法实现生产者与消费者模式
 */
public class PThread12ReentrantLock {
    public static void main(String[] args) {
        Storage storage = new Storage(100);
        Producer1 producer1 = new Producer1("生产者1", storage);
        Consumer1 consumer1 = new Consumer1("消费者1", storage);
        Producer1 producer2 = new Producer1("生产者2", storage);
        Consumer1 consumer2 = new Consumer1("消费者2", storage);
        Producer1 producer3 = new Producer1("生产者3", storage);
        Consumer1 consumer3 = new Consumer1("消费者3", storage);
        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();
        producer3.start();
        consumer3.start();
    }
}

/**
 * 生产者线程
 */
class Producer1 extends Thread {
    private Storage storage;

    public Producer1(String name, Storage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                storage.pro();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者线程
 */
class Consumer1 extends Thread {
    private Storage storage;

    public Consumer1(String name, Storage storage) {
        super(name);
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            storage.con();
        }
    }
}

/**
 * 仓库类
 */
class Storage {
    private final ArrayList stor = new ArrayList();
    //仓库容量,初始化时确定,不可修改
    private final int size;
    //使用ReentrantLock进行线程同步,保证其唯一
    private final ReentrantLock reentrantLock = new ReentrantLock();
    //使用reentrantLock的newCondition方法获取Condition实例
    //使用Condition的await()与single() singleAll()方法实现生产者与消费者模式
    Condition proCondition = reentrantLock.newCondition();
    Condition conCondition = reentrantLock.newCondition();

    public Storage(int size) {
        this.size = size;
    }

    /**
     * 生产者方法
     */
    public void pro() throws Exception {
        //获得锁
        reentrantLock.lock();
        if (stor.size() == size) {
            //唤醒一个消费者线程
            conCondition.signal();
            //仓库已满无法生产,进入阻塞等待
            proCondition.await();
        } else {
            stor.add(new Object());
            System.out.println(Thread.currentThread().getName() + ":生产了一件商品,库存:" + stor.size());
        }
        //释放锁
        reentrantLock.unlock();
    }

    /**
     * 消费者方法
     */
    public void con() {
        reentrantLock.lock();
        if (stor.size() == 0) {
            try {
                //唤醒一个生产者线程
                proCondition.signal();
                //唤醒所有生产者线程
//                proCondition.signalAll();
                //没有商品,无法消费,进入阻塞等待
                conCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            stor.remove(stor.size() - 1);
            System.out.println(Thread.currentThread().getName() + ":消费了一件商品,库存:" + stor.size());
        }
        reentrantLock.unlock();
    }
}