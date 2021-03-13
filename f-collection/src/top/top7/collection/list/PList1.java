package top.top7.collection.list;

/******
 *       Created by LEARNING on 2020/10/29 14:37.
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
import java.util.List;

/**
 * list特点: 元素有序可重复,有下标,可存取 null
 * 若下标越界则会报异常(以size元素个数为准,不以底层具体实现的容量为准)
 *
 * List接口中特有的常用方法:
 *
 * 1. add(int index,E e);void
 * 2. set(int index,E e);E oldEle
 * 3. get(int index);E
 * 4. indexOf(Object o);int
 * 5. lastIndexOf(Object o);int
 * 6. remove(int index);E
 */
public class PList1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("我是1");
        list.add("我是2");
        list.add("我是3");
        list.add("我是4");
        list.add("我是王五");
        list.add("我是王五");
        list.add("我是7");
        list.add("我是8");
        list.add("我是9");
        list.add("我是10");

        //1.根据下标向集合中添加元素,当前下标之后元素统一后移一位,该方法没有返回值
        //index的值可以为最大下标+1,意为添加到末尾
        list.add(2, "我是李四");

        //2.根据下标设置元素的值,返回之前的值
        String oldEle = list.set(2, "李四不见了");
        System.out.println("我是谁:" + oldEle);

        //3.根据下标获取元素
        String e2 = list.get(2);
        System.out.println("是谁在这里:" + e2);

        //4.获取元素第一次出现的位置,内部调用equals方法进行比较,自定义类需要重写equals方法
        int findex = list.indexOf("我是王五");
        System.out.println("王五在哪里:" + findex);

        //5.获取元素最后一次出现的位置
        int lindex = list.lastIndexOf("我是王五");
        System.out.println("最后一个王五在哪里:" + lindex);

        //6.根据下标移除元素,并返回该元素
        String remove = list.remove(2);
        System.out.println("谁被删掉了:" + remove);


        for (String s : list) {
            System.out.println(s);
        }
    }
}
