package top.top7.exception;

/******
 *       Created by LEARNING on 2020/10/28 12:28.
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
 * 关于 try{}catch{}finally{} 中的return:
 *
 * 在 try | catch 中遇到return时, 方法返回值就已经确定
 *
 * 在finally中修改try | catch 中返回值变量的值并不能改变该方法的返回值
 *
 * 除非在finally中使用return覆盖 try | catch 块中的return
 */
public class PException5 {
    public static void main(String[] args) {
        int i = t1();
        System.out.println(i);
    }

    private static int t1() {
        int i =100;
        try {
            return i;
        }finally {
             i++;
        }
    }
}
/*
当前类字节码反编译之后:
public class PException5 {
    public PException5() {
    }

    public static void main(String[] args) {
        int i = t1();
        System.out.println(i);
    }

    private static int t1() {
        byte i = 100;

        try {
            ;
        } finally {
            byte var10000 = i;
            int var5 = i + 1;
            return var10000;
        }
    }
}
 */