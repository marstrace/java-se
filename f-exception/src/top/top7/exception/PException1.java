package top.top7.exception;

/******
 *       Created by LEARNING on 2020/10/27 14:41.
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

import java.io.IOException;

/**
 * 异常处理的两种方式:
 *
 * 1. 在方法声明的位置使用throws关键字抛出,谁调用我这个方法,我就抛给谁,交由调用者进行处理
 *
 * 2. 使用try catch块进行捕获处理
 */
public class PException1 {
    public static void main(String[] args) {
        m1();
    }

    static void m1() {
        //使用try{}catch{}语法对异常进行捕获并处理,捕获后的异常不会影响代码在try块外继续向下执行
        try {
            System.out.println("此处代码正常执行m1");
            m2();
            System.out.println("因m2方法会抛出异常,try块中的代码在执行m2方法调用处结束执行,此处代码不会执行");
        } catch (Exception e) {//try块中产生异常后,将会跳到catch块中逐行执行
            //jdk8新特性 catch  (IOException | NoSuchThreadPoolException | NullPointerException e) 并列的异常类不能有父子类包含关系
            // 此处的变量 e  指向的是异常声明位置new的异常对象, 支持父类引用指向子类对象

            e.printStackTrace();//打印异常堆栈追踪信息到控制台,包含异常出现位置及异常描述信息
            //java后台打印异常堆栈追踪信息的时候,采用了异步线程的方式打印
        }//也可使用多个catch块,将按照由上往下第一个匹配到的catch进行匹配并执行其catch内的代码


        System.out.println("异常在捕获后将会继续向下执行m1");
    }

    static void m2() throws Exception {
        System.out.println("此处代码正常执行m2");
        m3();
        System.out.println("m3方法的异常会继续向上抛出,当前方法会从m3方法的调用处结束,此处代码不会执行");
    }

    static void m3() throws Exception {//在方法声明后使用 throws 异常类声明  抛出异常给到调用者,可抛出
        // 多个用逗号隔开static void m3() throws NullPointerException, IOException

        System.out.println("此处代码正常执行m3");

        //产生异常代码: new一个异常对象并抛出
        //创建 异常对象时若不传入异常描述信息 其 相关内容则为空值 null
        throw new IOException("我是异常描述");//若抛出异常,当前方法将从此处终止

//        System.out.println("若产生异常,此处代码将不会执行");
    }
}
