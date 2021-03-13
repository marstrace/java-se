package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/6 21:17.
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
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;//JUC包,java的并发包,老jdk中没有这个包,新特性

/**
 * 创建线程的第三种方式(JDK8新特性):
 * 1. 编写自定义类实现java.util.concurrent.Callable接口,并重写未实现方法call(),call()类似于Runnable的run()方法,只不过call()方法有返回值
 * 2. 创建java.util.concurrent.FutureTask对象,将Callable接口的实现类对象作为构造参数传入
 * 3. 创建java.util.Thread对象,将FutureTask对象作为构造参数传入
 */
public class CreateThread3 {
    public static void main(String[] args) throws Exception {

        //2. 创建一个未来任务类对象,JUC包下的FutureTask类
        //1. Future类构造参数中需要传入Callable对象,也可传入Runnable对象,只不过run方法没有返回值
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = dateFormat.format(new Date());
                Thread.sleep(10000);
                return format;
            }
        });

        //3. 创建Thread对象,将FutureTask对象传入,并启动线程
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        //4. 在当前main线程中使用Future的实例方法get()获取t1线程call()方法的返回值
        //get方法需要等待t1线程的call()方法的执行结束才能获取到线程的返回值,因此只有当t1线程结束了,当前线程才可以继续向下执行
        String o = futureTask.get();
        System.out.println(o);
    }
}
