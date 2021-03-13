package top.top7.annotation.test;

/******
 *       Created by LEARNING on 2021/2/4 0:30.
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

import java.lang.reflect.Field;

/**
 * 题目:有一个名为id的注解,该注解只可以修饰类.
 * 要求被该注解修饰的类必须存在一个int类型的id属性,没有该属性则报异常,有则正常执行
 */
@Id
public class Test1 {
    int id;

    public static void main(String[] args) {

        try {
            Class aClass = Class.forName("top.top7.annotation.test.Test1");
            //判断该类是否存在@Id注解
            if (aClass.isAnnotationPresent(Id.class)) {
                //判断该类是否存在id属性,不存在则抛出异常
                try {
                    //尝试反射获取该类的id属性,若该类不存在id属性则抛出TypeNotIdException异常
                    Field id = aClass.getDeclaredField("id");
                    //若该类存在id属性,则判断属性类型是否是int,不是则抛出异常
                    if (!"int".equals(id.getType().getName())) {

                        throw new Exception();
                    }
                } catch (Exception e) {
                    throw new TypeNotIdException("被注解@Id修饰的类必须含有int类型的id属性");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
