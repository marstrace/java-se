package top.top7.collection;

/******
 *       Created by LEARNING on 2020/10/28 20:03.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection接口之迭代器:
 *
 * Collection接口继承了Iterable接口,Iterable接口中有一个iterator()未实现方法,该方法返回一个Iterator对象
 *
 * Iterator类有三个实例方法:
 * hasNext();boolean
 * Next();E
 * remove();boolean
 *
 * 注意:
 * 1. 集合只要发生改变,迭代器必须重新获取
 * 2. 迭代器的remove方法会同时删除迭代器快照与原集合中的元素，此时两者的状态是相同的，不需要重新获取迭代器
 */
public class PCollection2Iterator {

    /**
     * 迭代器的三个方法
     */
    static void m1() {
        Collection<String> co = new ArrayList();

        co.add("zhangsan1");
        co.add("zhangsan2");
        co.add("zhangsan3");
        co.add("zhangsan4");
        co.add("zhangsan5");

        //调用Collection的iterator();方法获取迭代器对象
        Iterator<String> iterator = co.iterator();

        //1.调用迭代器的hasNext();方法判断是否有下一个元素
        boolean b = iterator.hasNext();
        System.out.println(b);

        //2.调用next();方法获取集合的下一个元素
        String next = iterator.next();
        System.out.println(next);

        //3.删除迭代器的next()方法最后一次调用时返回的元素,迭代器的remove方法会同步删除迭代器快照与原集合中的元素,因此不用重新获取迭代器
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(co.size());
    }


    public static void main(String[] args) {

        System.out.println(0x7fffffff);
    }

    /**
     * 1. 集合结构只要发生改变,迭代器就必须重新获取
     * 2. 迭代器的remove方法会同时删除迭代器快照与原集合中的元素，此时两者的状态是相同的，不需要重新获取迭代器
     */
    static void m2() {
        Collection<String> co = new ArrayList();

        co.add("zhangsan1");
        co.add("zhangsan2");
        co.add("zhangsan3");

        //调用iterator();方法获取迭代器对象
        Iterator<String> iterator = co.iterator();
        co.add("zhangsan4");
        co.add("zhangsan5");

//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        iterator.next();
    }
}
