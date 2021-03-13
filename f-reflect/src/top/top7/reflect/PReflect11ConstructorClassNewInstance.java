package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/12 16:10.
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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射调用构造方法创建实例:
 *
 *  Class类的newInstance()方法从JDK9开始就已经过时不建议使用了,因此应尽量使用Constructor类的newInstance()方法来反射创建实例
 */
public class PReflect11ConstructorClassNewInstance {
    public static void main(String[] args) {
        Class<StringBuilder> stringBuilderClass = StringBuilder.class;

        try {
            //反射通过参数列表获取构造方法
            Constructor<StringBuilder> declaredConstructor = stringBuilderClass.getDeclaredConstructor(String.class);

            //通过调用Constructor类的实例方法newInstance()方法创建实例,参数为构造方法实参
            StringBuilder stringBuilder = declaredConstructor.newInstance("awesome...");
//            StringBuilder stringBuilder = declaredConstructor.newInstance();
            stringBuilder.append("don't");
            System.out.println(stringBuilder);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
