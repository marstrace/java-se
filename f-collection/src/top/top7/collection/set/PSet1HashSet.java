package top.top7.collection.set;

/******
 *       Created by LEARNING on 2020/11/1 11:12.
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

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet集合的底层是HashMap集合,往HashSet集合中存储元素,实际上是将元素存在了HashMap集合的key中
 * HashSet集合中的元素必须重写 hashCode(); 与 equals();方法
 * 无序不可重复,可以存储一个null值
 */
public class PSet1HashSet {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("jafzhdj");
        strings.add("jafhyj");
        strings.add("jafhsj");
        strings.add("jfafasshj");
        strings.add("jafvhj");
        strings.add("jaccfhjs");
        strings.add("jafbhj");
        strings.add(null);
        //foreach遍历
        for (String s : strings) {
            System.out.println(s);
        }

        //迭代器遍历
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
