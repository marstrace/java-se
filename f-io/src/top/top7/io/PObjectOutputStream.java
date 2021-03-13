package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/2 16:45.
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

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象序列化: ObjectOutputStream
 * 1. 参与序列化/反序列化的对象, 必须实现 java.io.Serializable接口,
 * Serializable接口只是一个标志接口, 没有方法与属性,jvm在发现该接口后会为该类生成一个序列化版本号
 * 2. 可以一次序列化多个对象,可以直接多次调用writeObject(Object)方法序列化,反序列化时也多次调用readObject()方法,
 *      或将对象添加到集合中,序列化集合, 集合以及当中的元素都需要实现呢Serializable接口
 * 3. 类发生改变,序列化版本号 会重新生成,改变之前序列化的数据会无法反序列化
 * 5. 序列化版本号是用来区分 类 的,当全限定类名相同时,使用序列化版本号来区分类
 * 6. 凡是一个类实现了Serializable接口,建议给该类一个固定不变的版本号
 * 7. 建议使用Idea生成序列化版本号
 */
public class PObjectOutputStream {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("f-io/src/student"));
        objectOutputStream.writeObject(new Student("zhangsan",23));
        objectOutputStream.writeObject(new Student("lisi",22));
        objectOutputStream.close();
    }
}

class Student implements Serializable {
    //参与序列化的类,建议手动给定序列化版本号,设置idea通过idea进行设置序列化版本号,通过idea生成的版本号全球唯一
    private static final long serialVersionUID = 6095330131275353266L;


    private String name;
    //transient关键字,修饰属性,该属性不参与序列化
    private transient int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
}
