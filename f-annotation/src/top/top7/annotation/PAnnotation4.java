package top.top7.annotation;

/******
 *       Created by LEARNING on 2021/2/4 0:04.
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

import top.top7.annotation.myannotation.MyAnnotation3;

import java.lang.reflect.Method;

/**
 * 反射获取方法上的注解及注解的属性值
 */
public class PAnnotation4 {

    @MyAnnotation3(name = "zhangsan", pass = "1258")
    public void getUser() {

    }

    /**
     * 反射获取方法上的注解及其属性值
     */
    public static void main(String[] args) throws Exception {
        //1.获取类PAnnotation的字节码对象
        Class aClass = Class.forName("top.top7.annotation.PAnnotation4");
        //2.获取类的方法
        Method getUser = aClass.getDeclaredMethod("getUser");
        //3.判断该方法是否被注解@MyAnnotation3修饰
        if (getUser.isAnnotationPresent(MyAnnotation3.class)) {

            //4.获取方法上注解的字节码对象
            // 这里为什么不需要强转????
            MyAnnotation3 annotation = getUser.getAnnotation(MyAnnotation3.class);

            //5.获取注解属性值
            System.out.println(annotation.name() + "------" + annotation.pass());
        }
    }
}
