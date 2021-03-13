package top.top7.oop;

import org.junit.Test;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/8 13:00.
 *
 * ********************************
 *
 * @author top234
 *
 *         instanceof 运算符:
 *         1. instanceof可以在运行阶段动态判断引用指向的对象的类型
 *         2. instanceof的语法：（引用 instanceof 类型）
 *         3. instanceof运算符的运算结果只能是true 或 false
 */
public class POOP3_instanceof {
    @Test
    public void test1() {
        String string = new String();
        System.out.println(string instanceof Object);
    }
}