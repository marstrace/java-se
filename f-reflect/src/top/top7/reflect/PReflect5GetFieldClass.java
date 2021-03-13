package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/10 16:53.
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
import java.lang.reflect.Modifier;

/**
 * 根据字节码反编译类中的属性
 */
public class PReflect5GetFieldClass {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("java.util.ArrayList");

        Field[] declaredFields = aClass.getDeclaredFields();

        //获取类名及访问权限修饰符
        System.out.println(Modifier.toString(aClass.getModifiers()) + " class " + aClass.getSimpleName() + "{");

        //获取方法名及访问权限修饰符
        for (Field f : declaredFields) {
            System.out.println("\t" + Modifier.toString(f.getModifiers()) + " " + f.getName() + ";");
        }

        System.out.println("}");
    }
}
