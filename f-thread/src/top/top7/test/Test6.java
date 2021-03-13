package top.top7.test;

/******
 *       Created by LEARNING on 2020/11/6 23:29.
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

import java.io.File;

/**
 * 测试循环的执行效率
 */
public class Test6 {
    public static void main(String[] args) {
//        long l = System.currentTimeMillis() + 10000;
//        for (int i = 1; ; i++) {
////            if (System.currentTimeMillis() > l) System.exit(0);
//            if (System.currentTimeMillis() > l) return;
//            System.out.println(i);//199219 每秒
//        }
        File file = new File("I:/tt");
        boolean temp = file.renameTo(new File("C:/t"));
        System.out.println(temp);
    }
}