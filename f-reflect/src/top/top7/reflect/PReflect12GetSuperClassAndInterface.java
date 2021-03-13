package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/12 16:22.
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
import java.lang.reflect.Method;

/**
 * 反射获取一个类的父类及实现的接口:
 * 基本数据类型没有父类和实现接口,也没有属性 方法 构造方法
 */
public class PReflect12GetSuperClassAndInterface {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("java.lang.String");
            //反射获取父类
            Class<?> superclass = aClass.getSuperclass();
            System.out.println("父类:" + superclass.getName());
            //反射获取实现接口
            Class<?>[] interfaces = aClass.getInterfaces();
            for (Class c : interfaces) {
                System.out.println(c.getName());
            }

            //基本数量类型没有父类和实现接口 方法 属性 构造方法
            Class<Integer> integerClass = int.class;
            System.out.println(integerClass.getSuperclass() == null);
            System.out.println(integerClass.getInterfaces().length == 0);


            Field[] declaredFields = integerClass.getDeclaredFields();
            System.out.println(declaredFields.length == 0);
            Method[] declaredMethods = integerClass.getDeclaredMethods();
            System.out.println(declaredMethods.length == 0);
            System.out.println(integerClass.getDeclaredConstructors().length == 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}