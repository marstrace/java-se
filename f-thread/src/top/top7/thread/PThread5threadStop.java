package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/4 15:37.
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
 * 如何强行终止一个线程:
 * t.stop();终止线程t, 已过时,不建议使用,可能会丢失数据,直接杀死线程
 *
 * 如何合理的终止一个线程的执行:
 * 打标记法,使线程合理结束
 */
public class PThread5threadStop {
    public static void main(String[] args) {
        MyThread3 t3 = new MyThread3();
        t3.setName("t3");
        t3.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
            if (i == 5) {
                //改变t3线程的status属性
                t3.stopThread();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread3 extends Thread {
    //打一个标记
    private boolean status = true;

    public void stopThread() {
        status = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (status) {//当属性status为true时才会执行,为false则结束当前方法

                System.out.println(Thread.currentThread().getName() + "---->" + i);
                try {
                    sleep( 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                //....
                //在return之前执行线程结束前的善后工作,比如保存数据
                return;
            }
        }
    }
}