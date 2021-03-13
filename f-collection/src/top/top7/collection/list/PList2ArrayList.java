package top.top7.collection.list;

/******
 *       Created by LEARNING on 2020/10/29 16:56.
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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * ArrayList的三个构造方法:
 *
 * 1.无参
 * 2.数组初始大小参数
 * 3.Collection集合参数
 *
 * 将ArrayList集合转换为线程安全的:
 * 使用java.util.Collections类中的Collections.synchronizedList(strings);方法
 */
public class PList2ArrayList {
    public static void main(String[] args) {

        //1
        ArrayList<String> strings = new ArrayList<>();

        //2
        ArrayList<Object[]> objects1 = new ArrayList<>(100);

        //3
        ArrayList<Object> objects = new ArrayList<>(new HashSet<>());

        strings.add("jajf");

        //将非线程安全的ArrayList集合转换为线程安全的
        //此处的返回值与传进去的变量不是一个指向同一个地址,但两者的内容相同会被同步,操作其中一个另一个也会同步
        List<String> list = Collections.synchronizedList(strings);

        strings.add("44");
        list.add("55");
        System.out.println(list==strings);
        System.out.println(list.equals(strings));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(strings.get(2));
    }
}
