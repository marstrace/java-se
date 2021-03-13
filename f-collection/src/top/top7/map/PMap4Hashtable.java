package top.top7.map;

/******
 *       Created by LEARNING on 2020/10/30 22:15.
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

import java.util.Collections;
import java.util.Properties;

/**
 * Hashtable 集合:
 * 1. 底层同样是哈希表
 * 2. key 与 value 值都不能为null
 * 3. 线程安全,效率低,不建议使用
 * 4. 初始化容量是 11 ,默认加载因子是0.75, 扩容为 原容量*2+1(原容量左移一位并加一)
 *
 * Properties属性类:
 * 1. 继承了HashTable
 * 2. 线程安全
 * 3. key 和 value 都只能是String类型
 */
public class PMap4Hashtable {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //强烈不建议使用继承来的put();putAll();get()方法
        /*Object o = new Object();
        properties.put(o,new Object());
        Object o1 = properties.get(o);
        System.out.println(o1);*/

        //使用setProperty来存储String类型的  key-value ,key存在则覆盖,并返回之前的value,不存在则添加元素,并返回null
        properties.setProperty("url", "jdbc:mysql://localhost:3306/study");
        Object url = properties.setProperty("url", "jdbc:mysql://localhost:3306/study1");
        System.out.println(url);
        //使用getProperty方法来通过key获取value
        String url1 = properties.getProperty("url");
        System.out.println(url1);
    }
}
