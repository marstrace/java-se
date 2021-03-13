package top.top7.oop;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/10 5:32.
 *
 * ********************************
 *
 * @author top234
 *
 *         内部类:
 *         1.实例内部类
 *         2.静态内部类
 *         3.局部内部类
 *         4.匿名内部类
 */
public class InnerClass {
    public static void main(String[] args) {
        //匿名内部类
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("---+--------+--");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
