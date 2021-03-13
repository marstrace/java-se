package top.top7.thread;

/******
 *       Created by LEARNING on 2020/11/5 11:02.
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
 * 在多线程并发时,若多个线程会共享并修改相同的数据,则有可能会产生线程安全问题
 *
 * 使用线程同步机制解决线程安全问题: synchronized
 * 1. 使用 synchronized() 修饰需要排队执行的代码:同步代码块
 *
 * synchronized(需要排队的线程共享的对象,(比如:需要排队的原因,可以是字符串常量池中的字符串)){
 * 需要排队执行的代码
 * }//同步代码块越小效率越高
 *
 * 在java语言中任何一个对象都有一把锁,其实这把锁就是一个标记(只是把它叫做锁),100个对象100把锁
 *
 * 2. 使用synchronized修饰实例方法:
 * synchronized修饰实例方法,一定锁的是this,也只能是this,这种方式不灵活,且整个方法都会被同步,可能会扩大同步范围,导致程序执行效率降低,所以这种方式不常用
 * synchronized修饰实例方法的优点: 代码节俭; 如果整个方法都需要同步,且锁是this的话,建议使用这种方式
 *
 * 3. 使用synchronized修饰静态方法:
 * 表示找类锁,同一个类永远只有一把锁
 */
public class PThread6synchronized {
    public static void main(String[] args) {
        Account account = new Account("an-001", 10000D);
        MyThread4 t1 = new MyThread4(account);
        MyThread4 t2 = new MyThread4(account);
        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getYue());
    }
}


/**
 * 模拟银行取款流程
 */
class MyThread4 extends Thread {
    private Account ac;

    public MyThread4(Account ac) {
        this.ac = ac;
    }

    //模拟取钱流程
    @Override
    public void run() {
        ac.qukuan(5000.5);
        System.out.println("线程:" + Thread.currentThread().getName() + "取款成功,账户:" + ac.getAN() + "的当前余额为:" + ac.getYue());
    }
}

/**
 * 银行账户类
 */
class Account {
    //账号
    private String AN;
    //余额
    private double yue;

    public void qukuan(double m) {
        //使用synchronized修饰需要排队执行的代码块
        synchronized (this) {
            double yue = getYue();
            double after = yue - m;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setYue(after);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "AN='" + AN + '\'' +
                ", yue=" + yue +
                '}';
    }

    public String getAN() {
        return AN;
    }

    public void setAN(String AN) {
        this.AN = AN;
    }

    public double getYue() {
        return yue;
    }

    public void setYue(double yue) {
        this.yue = yue;
    }

    public Account(String AN, double yue) {
        this.AN = AN;
        this.yue = yue;
    }
}