package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/7 12:58.
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
import java.util.List;

/**
 * 生产者与消费者模式:Object类的 wait 与 notify 的使用
 * 1. wait() 与 notify() 方法建立在线程同步的基础之上, 必须是当前线程所持有的 锁去调用wait与notify,notifyAll方法(类锁其实是类的Class类对象,是对象自然也可以调用Object类的方法)
 *      否则会报异常:java.lang.IllegalMonitorStateException: current thread is not owner(当前线程不是持有者)
 *
 * 2. o.wait(); //让当前持有锁o的线程t进入等待状态(阻塞状态的一种),并释放掉t线程之前占有的锁o
 *         进入等待状态的线程t会在线程执行的当前位置(wait()方法处)等待被唤醒,当被唤醒后则去锁池找锁,获得锁后会从当前位置继续向下执行
 *
 * 3. o.notify();//唤醒一个因o.wait()方法 进入阻塞等待状态的线程(先进先出,先被wait的线程先唤醒),只是通知,不会释放当前线程(执行o.notify()方法的线程)占有的锁o
 *
 * 4. o.notifyAll();//唤醒所有因o.wait()方法 阻塞等待的线程
 */
public class PThread10WaitAndNotify {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        Producer producer = new Producer(list, "producer");
        Consumer consumer = new Consumer(list, "consumer");
        producer.start();
        consumer.start();
    }
}


/**
 * 生产者
 */
class Producer extends Thread {
    private List list;

    public Producer(List list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                //仓库满了,停止生产
                if (list.size() == 10) {
                    try {
                        list.wait();//必须是当前线程持有的锁,才可以调用wait方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //生产一个商品
                Object o = new Object();
                list.add(o);
                System.out.println("生产者生产了:---->" + o + "-->当前仓库还有" + list.size() + "件商品");
                list.notify();//必须是当前对象持有的锁,才可以调用notify方法
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    private List list;

    public Consumer(List list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                //仓库空了,停止消费
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //消费一个商品
                Object remove = list.remove(list.size() - 1);
                System.out.println("消费者消费了:---->" + remove + "-->当前仓库还有" + list.size() + "件商品");
                list.notify();
            }
        }
    }
}