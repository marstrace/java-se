package top.top7.map;

/******
 *       Created by LEARNING on 2020/10/30 13:53.
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
 * Map和Collection没有继承关系:
 * Map以key-value 的方式存储数据, key和value都是引用数据类型,都是存储对象的内存地址,key起到主导作用,value是key的一个附属品
 *
 * Map接口的常用方法:
 *
 * 1. put(K ,V);V
 * 2. get(K);V
 * 3. clear();void
 * 4. containsKey(Object);boolean
 * 5. containsValue(Object);boolean
 * 6. isEmpty();boolean
 * 7. remove(Object);V  / remove(Obj,Obj);boolean
 * 8. size();int
 * 9. values();Collection<V>
 * 10. keySet();Set<K>
 * 11. entrySet();Set<Map.Entry<K,V>> //返回一个Set集合对象,其中包含HashMap集合的所有元素
 */
public class PMap1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        //1.put 向集合中添加元素, 内部先调用key的hashCode方法确定元素存储数组位置,若该位置不为空,则调用equals方法与当前链表中的每一个元素进行比较,
        //  若没有相等的则将新元素添加到该链表末尾,并返回null,若存在相等的key则覆盖value值,并返回老的value
        String zhngsan = map.put(1, "zhngsan");
        String liis = map.put(1, "liis");
        System.out.println(liis);

        //2.get 通过key获取value值,key不存在则返回null
        String s = map.get(2);
        System.out.println(s);

        //3. clear  清空集合
        map.clear();
        map.put(1, "liis");
        map.put(2, "wangwu");
        map.put(3, "zhaoliu");

        //4. containsKey 集合中是否包含key
        boolean b = map.containsKey(new Object());
        System.out.println("这里包含2吗:" + b);

        //5. containsValue  集合中是否包含value
        boolean liis1 = map.containsValue("liis");
        System.out.println(liis1);

        //6. idEmpty 判断当前集合是否为空
        boolean empty = map.isEmpty();
        System.out.println(empty);

        //7. remove 根据key删除key-value 返回value
        String remove = map.remove(1);
        System.out.println(remove);

        //7. remove 根据key-value删除集合
        boolean wangwu = map.remove(2, "wangwu");
        System.out.println(wangwu);

        //8. size 获取集合元素的个数
        int size = map.size();
        System.out.println("size:" + size);

        //9. values 获取所有的value,封装为一个Collection集合对象
        Collection<String> values = map.values();
        System.out.println(values.size());

        //10. keySet 获取所有的key,封装为一个set集合
        Set<Integer> integers = map.keySet();

        //11. entrySet 将key-value集合转换为一个set集合,set集合的每一个元素为Map.Entry<K,V>对象,通过使用该对象的getKey方法可以获得Key,getValue方法可以获得value
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries.size());

        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "----" + next.getValue());
        }
    }
}


