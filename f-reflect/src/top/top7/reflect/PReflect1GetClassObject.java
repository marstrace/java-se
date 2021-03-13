package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/9 16:59.
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

/**
 * 获取Class类对象的三种方式(类的字节码文件)
 * 1. 使用java.lang.Class类的静态方法 forName()
 * Class.forName("String类型的全限定类名");Class
 * //静态代码块在只在类加载时执行,并且只执行一次,forName方法可以使类加载
 * //如果你只希望一个类的静态代码块执行,类的其他部分不执行,你可以使用:  Class.forName("全限定类名") 实现
 *
 * 2. 使用Object的实例方法getClass()获取当前对象的Class类对象
 * String s= new String(); Class StringClass = s.getClass();
 *
 * 3. java语言中任何任何一种类型(包括基本数据类型),都有.class属性
 * Class intClass = int.class;
 */
public class PReflect1GetClassObject {
    public static void main(String[] args) {
        try {
            //1.
            Class aClass = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.
        String s = new String();
        Class stringClass = s.getClass();

        //3.
        Class intClass = int.class;
        Class integetClass = Integer.class;
        System.out.println(intClass == integetClass);//基本数据类型与其包装类不是同一个Class类对象
    }
}
