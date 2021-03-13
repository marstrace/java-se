package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/12 0:02.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射机制调用方法:重点
 * 1. 使用Method的实例方法invoke()实现反射调用方法
 * 2. 方法调用四要素: 对象, 方法, 实参, 返回值
 * 3. 反射调用方法在传参时不能像正常调用时重载方法会自动匹配,在使用invoke()调用方法时只能传入与获取Method对象时相同类型的参数
 */
public class PReflect9InvokeMethod {
    public static void main(String[] args) {

        try {

            Class<?> aClass = Class.forName("java.lang.StringBuilder");
            //通过方法名和形参列表获取方法字节码
            Method append = aClass.getDeclaredMethod("append", String.class);
            //反射创建实例
            Object stringBuilder = aClass.newInstance();

            //通过Method对象的invoke方法实现反射调用方法,第一个参数为调用方法的队形,第二个参数为方法的实参
            //因为获取的是String参数的Method对象,此处只能传入String类型的参数, 不能像正常调用方法时的重载方法自动匹配
            append.invoke(stringBuilder, "don't ...");
            System.out.println(stringBuilder);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}