package top.top7.oop.constructor;

/******
 *       Created by LEARNING on 2021/2/24 16:29.
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
 * java面向对象之构造方法:
 * 1.构造方法的作用: 创建对象,并在创建对象的过程中给属性赋值(初始化)
 * 2.当一个类中没有提供任何构造方法,编译器会默认提供一个无参数的构造方法,这个无参数的构造方法叫做缺省构造器
 * 3.当一个类中手动提供了构造方法,那么编译器将不再提供无参数构造方法
 */
public class PConstructor1 {
    String username;
    String password;
}

//字节码文件反编译:
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
//package top.top7.oop.constructor;
//
//public class PConstructor1 {
//    String username;
//    String password;
//
//    public PConstructor1() {
//    }
//}
