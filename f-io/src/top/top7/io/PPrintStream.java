package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/1 18:29.
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

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream:标准字节输出流,默认输出到控制台
 * 1. 标准输出流不需要手动close()关闭
 * 2. System.setOut(printStream);设置标准输出流的输出方向为log文件
 */
public class PPrintStream {
    public static void main(String[] args) throws Exception {
        PrintStream out = System.out;
        out.printf("一次输出一行 ");


        //改变标准输出流的输出方向:
        //标准输出流不再指向控制台,指向"log"文件,并使用FileOutputStream将输出方式改为追加
        PrintStream printStream = new PrintStream(new FileOutputStream("f-io/src/log", true));

        //修改输出方向,将输出方向修改到"log"文件
        System.setOut(printStream);
        //再输出
        System.out.println("hello, world");
        System.out.println("hello, world");
        System.out.println("hello, world");
        System.out.println("hello, world");
        PrintStream printStream1 = new PrintStream(new FileOutputStream("f-io/src/log2", true));
        printStream1.println("我是日志信息");
    }
}
