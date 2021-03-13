package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/4 13:01.
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

import java.util.Scanner;

/**
 * 实现线程的第二种方式:
 * 1. 编写一个类,实现java.lang.Runnable接口,并重写未实现方法run()
 * 2. 创建java.lang.Thread类对象,并将自定义类的实例作为构造参数传入
 * 3. 使用thread的start()方法启动线程
 */
public class CreateThread2 {
    public static void main(String[] args) {
        //创建thread类对象,并传入自定义类的实例
        Thread thread = new Thread(new MyRunnable1());

        //启动线程
        thread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我是一"+i);
            if(i==350){
                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                System.out.println("我说了什么:"+next);
            }
        }
    }
}

/**
 * 编写类,实现Runnable接口.重写run()方法
 * 注意,这并不是一个线程类,是一个可运行的类
 */
class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是二"+i);
        }
    }
}