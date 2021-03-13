package top.top7.collection.list;

/******
 *       Created by LEARNING on 2020/10/30 9:00.
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

import java.util.*;

/**
 * List 之 Vector集合
 *
 * 1. Vector 集合底层是数组
 * 2. 数组初始化长度为10
 * 3. 每次扩容原来的一倍 10-->20
 * 4. 线程安全,效率低,很少使用
 */
public class PList4Vector {
    public static void main(String[] args) {
        List<String> strings = new Vector<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("10");

        strings.add("11");
        String s = strings.get(1);
        System.out.println(s);
    }
}
