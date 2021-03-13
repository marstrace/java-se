package top.top7.map;

/******
 *       Created by LEARNING on 2020/10/31 10:05.
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

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeMap的key底层为桶+红黑树数据结构
 *
 * 自定义TreeMap key中元素的排序比较规则:(两种方式必须实现一种,否则无法使用TreeSet,TreeMap的key存储自定义类)
 *
 * 方式一:元素类实现比较规则
 * 1. 元素类实现java.lang.Comparable接口,并重写compareTo方法自定义比较规则
 * 2. compareTo方法返回值为负数表示调用者在前(二叉树左侧),为零表示两者相等(覆盖value),大于零表示调用者在后(二叉树右侧)
 *
 * 方式二:自定义比较器,(当比较器存在时以比较器为准)
 * 1. 自定义比较器类实现java.util.Comparator接口,并重写compare未实现方法
 * 2. 将比较器对象以构造参数的形式传入集合中
 *
 * Comparable 与 Comparator 怎么选择:
 * 1. 当比较规则不会发生改变时,或者说当比较规则只有一个时,建议使用Comparable接口
 * 2. 如果比较规则有多个,并且需要规则之间频繁切换时,建议选择Comparator自定义比较器
 * 3. 当需要对jdk自带类进行排序且比较规则与其compareTo不同时,可以自定义比较器来使用自定义比较规则
 */
public class PMap5TreeMap {
    public static void main(String[] args) {
        TreeSet<String> strings = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        strings.add("zhangsan");
        strings.add("zhangsn");
        strings.add("lisi");
        strings.add("aliyun");
        for (String s:strings){
            System.out.println(s);
        }
    }
}

/**
 * 自定义类,实现Comparable接口.重写compareTo未实现方法
 */
class Customer implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
