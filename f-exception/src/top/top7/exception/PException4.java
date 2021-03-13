package top.top7.exception;

/******
 *       Created by LEARNING on 2020/10/28 10:33.
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
 * 使用debug模式查看代码执行流程
 *
 * 4.try{ }finaly{ } 块可以连用，try 块不能单独使用，当省略catch块时，因为没有捕获异常，若try块中的代码产生
 * 了异常，程序在执行完finally块后会直接停止
 */

public class PException4 {
    public static void main(String[] args) {
        m1();
        String o = null;
        System.out.println(o);//null
    }

    private static void m1() {
        m2();
    }

    private static void m2() {
        System.exit(2);
        System.out.println(1 / 0);
        //1/0执行后当前程序会直接结束
        try {
            System.out.println(1 / 0);
        } finally {
            System.out.println("this is finally");
        }

        System.out.println("此处代码不会执行");
    }
}
