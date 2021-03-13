package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/7 16:38.
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

/**
 * 1. wait() 与 notify() 方法的调用必须在同步代码块内,必须使用当前线程所持有的锁去调用这两个方法
 * 否则会报异常:java.lang.IllegalMonitorStateException: current thread is not owner(当前线程不是持有者)
 *
 * 2. wait()方法会使持有当前 锁的线程在当前执行位置进入阻塞状态,并释放掉持有的锁(调用wait方法的那个锁) ,当被别的持有了同
 * 一个锁的线程使用 锁.notify() 或 锁.notifyAll()方法唤醒后,被唤醒的线程会去锁池中找锁,当获得了锁后会在wait()方法执行处继续向下执行
 */
public class PThread11WaitAndNotifyAll {
    public static void main(String[] args) {
        Thread11 t1 = new Thread11();
        Thread11 t2 = new Thread11();
        Thread11 t3 = new Thread11();
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();

        Thread13 thread13 = new Thread13();
        Thread12 t22 = new Thread12();
        thread13.start();
        t22.start();
    }
}

/**
 * 线程一:
 */
class Thread11 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (Thread.class) {
            System.out.println("线程" + Thread.currentThread().getName() + "开始");
            try {
                Thread.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程" + Thread.currentThread().getName() + "结束");
    }
}

/**
 * 线程二:
 */
class Thread12 extends Thread {
    @Override
    public void run() {
        synchronized (Thread.class) {

            System.out.println("线程二二开始");
            System.out.println("线程二二结束");
            Thread.class.notify();
        }
    }
}

/**
 * 线程三:
 */
class Thread13 extends Thread {
    @Override
    public void run() {

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Thread.class) {
                System.out.println("线程搅屎棍开始");
                System.out.println("线程搅屎棍结束");
            }
        }
    }
}

