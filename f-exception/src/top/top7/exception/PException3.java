package top.top7.exception;

/******
 *       Created by LEARNING on 2020/10/28 9:27.
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try{}catch{}finally 的具体执行流程
 *
 * 1. 无论try | catch 块中是否产生异常，finally块中的代码都会被执行
 * 2. finally块中的return会使 try | catch 中的return失效
 * 3. return只要执行方法就会结束，在try | catch块中当return右侧的代码执行完后（此时当前return的返回值已经确定）会去执行finally块中的代码，最后结束方法，返回返回值
 * 4. try{}finaly 块可以连用，try 块不能单独使用，当省略catch块时，因为没有捕获异常，若try块中的代码产生了异常，程序在执行完finally块后会直接停止
 */
public class PException3 {
    public static void main(String[] args) {
        try {
            System.out.println("m1的返回值=" + m1());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static int m1() throws FileNotFoundException {
        int i = 1;
        try {
            System.out.println("我会正常执行");

            //产生异常的代码
            FileInputStream fk = new FileInputStream("I:\\test\\alyECS\\index.jsp");

            return i += 10; //执行流程 若上方代码没有产生异常,先执行 i +=10 ,使 i=11 , 接着在执行return前先去执行finally块中的代码,最后结束方法,返回返回值 i
            //System.out.println("若上方出现异常我则不会被执行");

            //try块中若产生异常,则会跳到catch块中执行
        } catch (RuntimeException | IOException e) {

            e.printStackTrace();

            //本行代码执行流程: 先执行 i +=20 ,使 i=21 , 接着在执行return前先去执行finally块中的代码,最后结束方法,返回返回值 i
            return i += 20;

            //无论try块 catch块中会不会产生异常,finally块中的代码都会被执行
        } finally {

            //此处若抛出异常，调用者的代码执行到调用处则会产生异常
//            FileInputStream fk = new FileInputStream("找不着");


            System.out.println(i);//此时i的值为 11 或 21

            //当前return会覆盖  try | catch 块中的return，并结束方法
            return i += 50;
        }
        //若try | catch | finally 块中都没有return 且没有产生异常，当前方法将会继续向下执行
//        return 0;
    }
}