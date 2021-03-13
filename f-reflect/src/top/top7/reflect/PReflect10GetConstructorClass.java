package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/12 15:49.
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
import java.lang.reflect.Modifier;

/**
 * 根据反射获取类的构造方法:
 * 反编译类的构造方法
 */
public class PReflect10GetConstructorClass {
    public static void main(String[] args) throws Exception {
        Class<StringBuilder> stringBuilderClass = StringBuilder.class;
        StringBuilder stringBuilder = stringBuilderClass.newInstance();

        stringBuilder.append(Modifier.toString(stringBuilderClass.getModifiers()));
        if (stringBuilderClass.getModifiers() != 0) stringBuilder.append(" ");

        stringBuilder.append("class ");
        stringBuilder.append(stringBuilderClass.getSimpleName());
        stringBuilder.append(" {\n");

        //通过类的Class对象获取类的构造方法
        Constructor<?>[] declaredConstructors = stringBuilderClass.getDeclaredConstructors();

        for (Constructor cons : declaredConstructors) {
            stringBuilder.append("\t");
            stringBuilder.append(Modifier.toString(cons.getModifiers()));
            if (cons.getModifiers() != 0) stringBuilder.append(" ");
            stringBuilder.append(stringBuilderClass.getSimpleName());
            stringBuilder.append(" (");
            Class[] parameterTypes = cons.getParameterTypes();
            for (Class c : parameterTypes) {
                stringBuilder.append(c.getSimpleName());
                stringBuilder.append(",");
            }
            if (parameterTypes.length != 0) stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("){ }\n");
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder);
    }
}
