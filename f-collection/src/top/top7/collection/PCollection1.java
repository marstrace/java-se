package top.top7.collection;

/******
 *       Created by LEARNING on 2020/10/28 18:49.
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

/**
 * Collection接口的常用方法:
 *
 * 1.add(E);boolean
 * 2.contains(Object);boolean
 * 3.clear();void
 * 4.remove(Object);boolean
 * 5.size();int
 * 6.isEmpty();boolean
 * 7.toArray();Object[]
 * 9.iterator();Iterator
 */
public class PCollection1 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();

        //向集合种添加一个元素
        boolean 张三2 = collection.add("张三");
        collection.add(new Exception("我是异常描述信息"));


        //获取集合中元素的个数
        int size = collection.size();
        System.out.println(size);

        //判断集合中是否包含某个元素
        boolean 张三 = collection.contains("张三");
        System.out.println(张三);

        //将集合转换成数组输出
        Object[] objects = collection.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }


        //移除集合中的某个元素
        boolean 张三1 = collection.remove("张三");
        System.out.println(张三1);

        System.out.println(collection.size());

        //判断当前集合是否为空
        boolean empty = collection.isEmpty();
        System.out.println(empty);

        //清空集合
        collection.clear();

        System.out.println(collection.size());
    }
}
