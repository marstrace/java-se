package top.top7.test;

/******
 *       Created by LEARNING on 2020/11/8 14:48.
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
public class Test7 {
    public static void main(String[] args) {

        MyThread7 t1 = new MyThread7();
        t1.start();
        int i = 10;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t1.setI(i++);
        }
    }
}

class MyThread7 extends Thread {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
