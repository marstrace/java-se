package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/5 11:21.
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
 * synchronized使用不当会产生死锁:
 * 死锁的代码演示: (要求会写死锁代码)
 * 1. synchronized在开发中最好不要嵌套使用
 * 2. 死锁在开发中很难调试
 */
public class PThread7deadlock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread thread1 = new Thread(new MyRunnable(o1, o2), "t1");
        Thread thread2 = new Thread(new MyRunnable(o2, o1), "t2");
        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    Object o1;
    Object o2;

    public MyRunnable(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {

            }
        }
    }
}


