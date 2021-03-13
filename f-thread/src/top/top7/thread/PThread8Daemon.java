package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/6 15:56.
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
 * 守护线程:
 * 1. java中有两种线程,用户线程与守护线程
 * 2. 只要所有的用户线程结束,守护线程会自动结束,main方法是用户线程
 * 3. t.setDaemon(true);在启动之前,将线程 t设置为守护线程
 */
public class PThread8Daemon {
    public static void main(String[] args) {
        MyDaemon daemon1 = new MyDaemon("daemon1");

        //在启动线程之前,将其设置为守护线程
        //在线程启动之后设置,执行到当前行则会抛出异常,但对已经启动的线程daemon1没有影响,异常是执行这行代码的线程的异常
        daemon1.setDaemon(true);
        daemon1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyDaemon extends Thread {
    @Override
    public void run() {
        //当所有的用户线程终止后,该守护线程也会终止
        while (true) {
            System.out.println("我是守护线程" + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyDaemon(String name) {
        super(name);
    }
}