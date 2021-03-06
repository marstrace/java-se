package top.top7.test;

/******
 *       Created by LEARNING on 2020/11/4 16:51.
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
 * 父类引用指向子类实例
 */
public class Test3 {
    public static void main(String[] args) {
        T1 t2 = new T2();
        t2.p();
    }
}

class T1 {
    public void p() {
        System.out.println("T1");
    }
}

class T2 extends T1 {
    @Override
    public void p() {
        System.out.println("T2");
    }
}