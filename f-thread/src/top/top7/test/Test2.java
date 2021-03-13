package top.top7.test;

import java.io.PrintStream;

/******
 *       Created by LEARNING on 2020/11/4 12:48.
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
public class Test2 {
    public static void main(String[] args) {
        //System.out的标准输出流对象是不是单例的?//是单例的
        PrintStream out = System.out;
        PrintStream out1 = System.out;
        System.out.println(out == out1);//是单例的

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(System.out);
            }
        };
        thread.start();
        System.out.println(System.out+"主");
    }
}
