package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/11 0:18.
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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过反射获取类中的方法:
 * 根据字节码反编译类中的方法
 */
public class PReflect8GetMethodClass {
    public static void main(String[] args) throws Exception {
        //获取类字节码
        Class<?> aClass = Class.forName("java.util.Collection");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Modifier.toString(aClass.getModifiers()) + " " + aClass.getSimpleName() + " {\n");

        //获取类中方法的字节码
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {

            //获取方法的修饰符
            stringBuilder.append("\t" + Modifier.toString(m.getModifiers()));
            stringBuilder.append(m.getModifiers() != 0 ? " " : "");
            //获取的方法的返回值类型的Class类对象
            //获取方法名
            stringBuilder.append(m.getReturnType().getSimpleName() + " " + m.getName());
            //获取方法的形参列表,Class类型的数组
            Class<?>[] parameterTypes = m.getParameterTypes();

            stringBuilder.append(" ( ");
            for (Class parameterType : parameterTypes) {
                //获取每一个形参的名称(简单名称)
                stringBuilder.append(parameterType.getSimpleName() + ",");
            }
            if (parameterTypes.length != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(" ) { }\n");
        }
        stringBuilder.append("}");

        System.out.println(stringBuilder);
    }
}
