package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/9 19:55.
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

import java.util.ResourceBundle;

/**
 * 使用资源绑定器读取属性配置文件:
 * 1. 只能绑定 xxx.properties文件,且要读取的文件必须在类路径下
 * 在绑定时文件的扩展名不能写,只写: xxx
 * 2. java.util.ResourceBundle
 */
public class PReflect4ResourceBundle {
    public static void main(String[] args) {

        //1.使用ResourceBundle的静态方法 getBundle("文件名")方法绑定属性配置文件,并返回ResourceBundle实例
        //不能写文件的扩展名,且文件扩展名必须是.properties
        ResourceBundle bundle = ResourceBundle.getBundle("info");

        //2.使用ResourceBundle的实例方法 getString("key"),通过key获value
        String name = bundle.getString("name");
        System.out.println(name);
    }
}
