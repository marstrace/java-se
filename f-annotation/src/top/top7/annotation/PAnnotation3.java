package top.top7.annotation;

/******
 *       Created by LEARNING on 2021/2/3 23:32.
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

import top.top7.annotation.myannotation.MyAnnotation2;

/**
 * 通过反射机制获取类上的注解及注解属性值
 */
@MyAnnotation2("present")
public class PAnnotation3 {
    public static void main(String[] args) {
        try {
            //获取类字节码对象
            Class aClass = Class.forName("top.top7.annotation.PAnnotation3");
            //判断该类是否被注解@MyAnnotation2修饰
            if (aClass.isAnnotationPresent(MyAnnotation2.class)){
                //反射获取注解@MyAnnotation的字节码对象
                MyAnnotation2 myAnnotation2 = (MyAnnotation2) aClass.getAnnotation(MyAnnotation2.class);

                //获取注解的属性
                String value = myAnnotation2.value();
                System.out.println("value= "+value);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
