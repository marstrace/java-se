package top.top7.collection.set;

/******
 *       Created by LEARNING on 2020/11/1 11:23.
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

import java.util.TreeSet;

/**
 * TreeSet的底层是TreeMap
 * 元素自然排序,存储自定义类需要自定义排序规则,不可重复,比较方法返回值为0表示两者相等
 * 重写compareTo方法或自定义比较器compare方法
 * 元素值不能为null
 */
public class PSet2TreeSet {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("lisi", 20));
        students.add(new Student("zhaol", 27));
        students.add(new Student("wangwu", 10));
        students.add(new Student("hahua", 27));
        students.add(new Student("hahua", 27));
//        students.add(null);//元素值不能为null
        for (Student s : students) {
//            students.remove(s);//在遍历集合时,不能对集合进行增删操作,java.util.ConcurrentModificationException
            System.out.println(s);
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;


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
    public int compareTo(Student o) {

        return -(this.age != o.age ? this.age - o.age : this.name.compareTo(o.name));
    }
}
