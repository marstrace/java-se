package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/9 17:33.
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
 * 使用类的字节码文件(Class类对象)创建对象
 * Class类的实例方法: newInstance()方法的使用
 */
public class PReflect2newInstance {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("top.top7.bean.User");

            //使用Class类的实例方法newInstance()创建对象,jdk9之后以过时
            //newInstance()方法调用无参构造创建实例,必须保证无参构造是存在的,否则会报异常
            Object o = aClass.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
