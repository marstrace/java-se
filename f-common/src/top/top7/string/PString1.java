package top.top7.string;

/******
 *       Created by LEARNING on 2021/2/5 14:58.
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

import java.io.Console;
import java.util.Arrays;

/**
 * 关于java.lang.String:
 * 1.String 表示字符串数据类型,属于引用类型
 * 2.在java中使用双引号括起来的都是字符串对象,每一个字符串都是一个对象
 * 3.java中规定,双引号括起来的字符串不可变,也就是`说"abc"从出生到死亡都只能是"abc"
 * 4.java中,使用双引号括起来的字符如"abc",都是存储在"方法区"的"常量池"当中的,是为了提升效率才这样做的,因为字符串使用太频繁
 */
public class PString1 {
    public static void main(String[] args) {
        //String类的常用构造方法
        //1.变量直接指向方法区中的字符串常量池
        String str1 = "awesome";
        //2.变量指向堆内存中的String对象,对象再指向方法区字符串常量池中的字符串常量
        String str2 = new String("don't");
        //3.将char数组转换为字符串对象
        char[] chars = {'a', 'c'};
        String str3 = new String(chars);
        //4.将byte数组转换为字符串对象
        byte[] bytes = {18, 25, 97, 108};
        String str4 = new String(bytes);
        System.out.println(str4);


        //String类中的常用方法
        //1.返回对应下标位置上的字符
        char c = str1.charAt(3);
        System.out.println(c);


        //2.按照字典顺序,比较两个字符串的大小
        int awww = str1.compareTo("awww");
        System.out.println(awww);


        //3.判断当前字符串中是否包含某个字符串
        boolean awe = str1.contains("awe");
        System.out.println(awe);


        //4.判断当前字符串是否以某个字符串结尾
        boolean me = str1.endsWith("me");
        System.out.println(me);


        //5.判断两个字符串是否相等
        boolean equals = "awesome".equals(str1);
        System.out.println(equals);


        //6.判断两个字符串是否相等,并忽略大小写
        boolean b = "awesome".equalsIgnoreCase(str1);
        System.out.println(b);


        //7.将字符串对象转换为字节数组(可使用参数设置编码方式)
        byte[] bytes1 = str1.getBytes();
        for (byte by : bytes1) {
            System.out.println(by);
        }

        //8.返回某个字符串/字符在当前字符串中第一次出现的位置,不存在则返回-1
        int es = str1.indexOf("yy");
        System.out.println(es);


        //9.判断当前字符串是否是空字符串,是空字符串返回true
        boolean empty = str1.isEmpty();
        System.out.println(empty);


        //10.获取字符串长度
        int length = str1.length();
        System.out.println(length);


        //11.判断某个字符串/字符在当前字符串中最后一次出现的位置,不存在则返回-1
        int e = str1.lastIndexOf('e');
        System.out.println(e);


        //12.使用新字符串替换原字符串中的所有子串
        String replace = str1.replace("e", "top");
        System.out.println(replace);

        //13.以某个字符串将原字符串拆分为String数组
        String[] split = "2020-02-20".split("-");
        for (String ss : split) {
            System.out.println(ss);
        }


        //14.判断当前字符串是否以某个字符串开始
        boolean aw = str1.startsWith("aw");
        System.out.println(aw);


        //15.按照下标截取字符串
        String substring = str1.substring(2);
        System.out.println(substring);


        //16.按照开始及结束下标截取字符串,包前不包后
        String substring1 = str1.substring(2, 4);
        System.out.println(substring1);


        //17.将字符串转换为char数组
        char[] chars1 = str1.toCharArray();
        for (char a:chars1) {
            System.out.println(a);
        }


        //18.将字符串转换为大写/小写
        String s = str1.toUpperCase();
        System.out.println(s);
        String s1 = "HDHHGFDJJ".toLowerCase();
        System.out.println(s1);


        //19.去除字符串前后空白
        String trim = " kdks vka ".trim();
        System.out.println(trim);



        //20.将非字符串转换为String, valueOf()是String类唯一的静态方法;将对象转为字符串时将调用其toString()方法
        String s2 = String.valueOf(44);
        System.out.println(s2);


        /**
         * StringBuilder相关测试
         * ----2021.02.15
         */
        /*
        StringBuilder awesome = new StringBuilder();
        System.out.println(awesome.length() + "----" + awesome.capacity());
        StringBuilder delete = awesome.delete(0, awesome.length());//返回当前对象this
        System.out.println(delete);
        System.out.println(delete == awesome);//true
        System.out.println(awesome + "-----" + awesome.capacity() + "-----" + awesome.length());


        //在idea中不能使用Console类
        Console console = System.console();
        String s1 = console.readLine("请输入用户名...");
        System.out.println(s1);

        char[] chars = "awesome".toCharArray();
        System.out.println(chars.length);
        */
    }
}
