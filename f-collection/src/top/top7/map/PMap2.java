package top.top7.map;

/******
 *       Created by LEARNING on 2020/10/30 16:11.
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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Map集合的两种遍历方式:Map集合没有迭代器,也无法通过foreach遍历
 *
 * 1.通过keySet方法获取所有key,再通过get方法获取value
 * 2.通过entrySet方法获取key-value的Set<Map.Entry<K, V>> 集合对象,每个key-value封装在Map.Entry对象中
 * 再通过Map.Entry对象的getKey()获取key, getValue();获取value
 */
public class PMap2 {
    public static void main(String[] args) {

    }

    /**
     * 方法一:
     */
    static void m1() {
        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(new Student("zhangsna", 32), "111");
        hashMap.put(new Student("lisi", 32), "ss");
        hashMap.put(new Student("zhangsna", 32), "11dd1");
        hashMap.put(new Student("ahf", 32), "11f1");

        //获取所有的key
        Set<Student> students = hashMap.keySet();
        for (Student s : students) {
            //通过get方法获取value
            System.out.println(s + "-----" + hashMap.get(s));
        }
    }

    /**
     * 方法二:
     */
    static void m2() {
        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(new Student("zhangsna", 32), "111");
        hashMap.put(new Student("lisi", 32), "ss");
        hashMap.put(new Student("zhangsna", 32), "11dd1");
        hashMap.put(new Student("ahf", 32), "11f1");

        //通过entrySet方法获取key-value的Set<Map.Entry<K, V>> 集合对象,每个key-value封装在Map.Entry对象中
        Set<Map.Entry<Student, String>> set = hashMap.entrySet();
        System.out.println(set.size());
        for (Map.Entry<Student, String> m : set) {
            System.out.println(m.getKey() + "-----" + m.getValue());
        }
    }
}


/**
 * 自定义类做HashMap集合key,需同时重写hashCode 与 equals 方法
 */
class Student {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
