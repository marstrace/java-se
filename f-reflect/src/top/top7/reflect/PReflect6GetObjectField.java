package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/10 15:22.
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
 * 通过反射机制获取实例的属性,并修改属性的值:重点
 */
public class PReflect6GetObjectField {
    public static void main(String[] args) {
        try {
            //根据反射获取类字节码,并使用无参构造创建实例
            Class<?> aClass = Class.forName("top.top7.bean.User");
            Object o = aClass.newInstance();

            //根据属性名称,获取类属性字节码
            Field nameField = aClass.getDeclaredField("name");
            System.out.println(nameField.getName());

            //打破属性的访问权限修饰符,在访问权限限定的范围之外也可以访问
            nameField.setAccessible(true);

            //根据Field类的实例方法set,给对象的属性设置值
            //第一个参数为要设置值的对象,第二个参数为属性值
            nameField.set(o, "zhangsan");

            //通过反射获取属性的值
            Object o1 = nameField.get(o);
            System.out.println(o1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
