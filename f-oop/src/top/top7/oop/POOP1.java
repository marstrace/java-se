package top.top7.oop;

/******
 *       Created by LEARNING on 2021/2/24 20:30.
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

/**
 * 面向对象三大特征之:封装
 *
 */
public class POOP1 {
    /**
     * 1.使用private访问权限修饰符私有化成员变量
     */
    private String name;
    private int age;

    /**
     * 2.对外部提供相应的 get set 方法
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

