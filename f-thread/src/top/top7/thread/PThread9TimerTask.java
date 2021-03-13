package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/6 20:03.
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务:使用java.util.Timer类实现定时任务
 */
public class PThread9TimerTask {
    public static void main(String[] args) throws Exception {
        //创建定时器对象
        Timer timer = new Timer();
//        Timer timer = new Timer(true);//设置为守护线程


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //设置定时任务
        //timer.schedule(java.util.TimerTask抽象类的实现类对象,任务开始时间:java.util.Date对象,每隔多长时间执行一次:long类型毫秒值)
        timer.schedule(new TimerTask() {
            //java.util.TimerTask抽象类实现了java.lang.Runnable接口,有run()方法
            @Override
            public void run() {
                String format = dateFormat.format(new Date());
                System.out.println(format + "完成了一次定时任务的执行");
            }
        }, dateFormat.parse("2020-11-06 20:56:30"), 3000);


        //一个定时器对象可以指定多个定时任务
        //设置定时任务
        //timer.schedule(java.util.TimerTask对象,任务开始时间:java.util.Date对象,每隔多长时间执行一次:long类型毫秒值)
        timer.schedule(new TimerTask() {
            //java.util.TimerTask抽象类实现了java.lang.Runnable接口,有run()方法
            @Override
            public void run() {
                String format = dateFormat.format(new Date());
                System.out.println(format + "一个Timer定时器对象可以指定多个定时任务");
            }
        }, dateFormat.parse("2020-11-06 21:00:30"), 3000);
    }
}
