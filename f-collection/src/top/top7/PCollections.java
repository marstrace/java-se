package top.top7;

/******
 *       Created by LEARNING on 2020/10/31 11:46.
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
import java.util.Comparator;
import java.util.Iterator;

/**
 * java.util.Collections工具类,方便对集合进行操作
 * 1. synchronized 将非线程安全集合转换为线程安全的,不需要接收返回值,直接操作原集合
 * 2. sort 对List集合本身进行排序,可以传入比较器参数,自定义类需指定排序规则,set集合可先转换list集合再使用sort方法排序
 */
public class PCollections {
    public static void main(String[] args) {
        ArrayList<Teacher> teachers = new ArrayList<>();

        //1. 将非线程安全的集合转换为线程安全的
        Collections.synchronizedList(teachers);
        teachers.add(new Teacher("老杜", 23));
        teachers.add(new Teacher("老李", 13));
        teachers.add(null);
        teachers.add(new Teacher("川普", 32));
        teachers.add(new Teacher("小弟", 3));
        teachers.add(null);
        teachers.add(new Teacher("拜登", 32));


        //2. 排序集合 自定义类需重写compareTo方法 或 sort方法同时传入比较器对象
        Collections.sort(teachers, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1 == o2) return 0;
                return o1 == null ? 1 : (o2 == null ? -1 : ((o1.age - o2.age) != 0 ? o1.age - o2.age : o1.name.compareTo(o2.name)));
            }
        });

        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Teacher {
    String name;
    int age;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
}