package top.top7.test;

/******
 *       Created by LEARNING on 2020/11/6 22:36.
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
 * 测试循环每秒可以执行多少次
 */
public class Test5 {
    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
//                System.exit(0);结束当前正在运行的JVM,与线程无关
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testFor();
            }

            void testFor() {
                for (int i = 1; ; i++) {
                    System.out.println(i);//166568 每秒
                }
            }

            void testWhile() {
                int i = 1;
                while (true) {
                    System.out.println(i++);//154684 每秒
                }
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
