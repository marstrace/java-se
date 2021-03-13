package top.top7.test;

/******
 *       Created by LEARNING on 2020/11/5 18:54.
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
 * 使用线程同步机制,实现多窗口购买火车票
 */
public class Test4 {
    public static void main(String[] args) {
        TicketLib ticketLib = new TicketLib(100);
        BuyT t1 = new BuyT(ticketLib, "t1");
        BuyT t2 = new BuyT(ticketLib, "t2");
        BuyT t3 = new BuyT(ticketLib, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}


class BuyT extends Thread {
    private TicketLib ticketLib;

    public BuyT(TicketLib ticketLib, String name) {
        this.ticketLib = ticketLib;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "这里执行了几次");
            ticketLib.buyTicket();
        }
    }
}

class TicketLib {
    int tic;

    public TicketLib(int tic) {
        this.tic = tic;
    }

    public synchronized void buyTicket() {
        if (tic > 0) {
            tic--;
            System.out.println(Thread.currentThread().getName() + "窗口成功售出了一张票,还剩余:" + this.tic + "张票 ");
        } else {
            System.out.println(Thread.currentThread().getName() + "没票啦,过会儿再来试试吧");
            try {
                //当在无票情况下,通过让持有锁的线程休眠,进而达到让锁休眠,减少该方法的无意义执行
                //若已经没有票了,那就让当前线程休眠一秒,而因为当前位置锁还没释放,其余窗口也不能进行购票,从而达到了当票售完的时候,该方法每隔一秒才会执行一次
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}