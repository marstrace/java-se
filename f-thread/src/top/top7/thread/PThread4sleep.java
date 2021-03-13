package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/4 14:46.
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
 * 关于线程的sleep方法:
 * static void sleep(long millis);//尽量使用try catch 处理该方法的异常,视代码逻辑而定
 * 1. 静态方法 Thread.sleep(1000); 1000毫秒等于1秒
 * 2. 参数是毫秒,1000毫秒等于1秒
 * 3. 作用: 让当前执行的线程进入休眠,进入"阻塞状态",放弃占有的cpu时间片,让出执行机会给其他线程
 * 4. 可以实现间隔特定时间,执行一次特定代码,每隔多久执行一次
 * 5. 如何唤醒休眠中的线程
 * t.interrupt();//实例方法,结束调用者的睡眠.结束t线程的睡眠,依靠异常处理机制,执行该方法会使使t线程睡眠的静态sleep方法产生异常,同时睡眠也就结束了
 * 6. 线程在sleep时不会让出占有的锁
 */
public class PThread4sleep {
    public static void main(String[] args) {
        MyThread2 t = new MyThread2();
        t.setName("t");
        //启动线程t
        t.start();

        //让当前线程休眠5秒,休眠结束后进入就绪状态
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我main线程又回来了");

        //在此处唤醒线程t
        t.interrupt();
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            sleep(1000 * 60 * 60 * 24 * 365);//使当前线程休眠一年
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}