package top.top7.exception;

/******
 *       Created by LEARNING on 2020/10/27 18:45.
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 异常对象的常用方法
 */
public class PException2 {
    public static void main(String[] args) {
        //可以在new对象时使用带参构造,传入自定义的异常描述信息
        NullPointerException exception = new NullPointerException("异常提示信息");

        //获取异常简单描述信息: 就是构造方法中传入的内容 若创建对象时没有传入内容 此方法则返回空值 null
        String message = exception.getMessage();
        System.out.println(message == null);

        //打印异常堆栈信息
        //java后台打印异常堆栈追踪信息的时候,采用了异步线程的方式打印
//        若创建对象时没有传入异常描述信息  此方法则不会打印异常描述信息
        exception.printStackTrace();

        System.out.println("方法printStackTrace()采用了异步线程");
    }
}
