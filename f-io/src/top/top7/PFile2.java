package top.top7;

/******
 *       Created by LEARNING on 2020/11/3 15:24.
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

import java.io.File;

/**
 * File中更多方法的测试
 * 1. length();long 返回文件的大小,单位为字节,若调用者是一个文件夹则返回0
 */
public class PFile2 {
    public static void main(String[] args) throws Exception {

        // 第一个构造参数传入上层文件夹的File对象, 第二个参数传入当前文件/文件夹的 name
        // 若上层File不存在,或不是一个文件夹,则会在创建当前FiLe文件时报异常,若创建为文件夹则会创建失败
       /* File temp1 = new File(new File("I:/top"), "temp1");
        boolean exists = temp1.exists();
        System.out.println(exists);
        boolean newFile = temp1.createNewFile();
        System.out.println(newFile);
        String parent = temp1.getParent();
        System.out.println(parent);
        File parentFile = temp1.getParentFile();
        System.out.println(parentFile);*/

        //1. 获取文件的大小,返回值为long类型数值,单位为字节,
        // 文件夹没有大小,若调用者是一个文件夹则会返回0
        File file = new File("I:/top");
        long length = file.length();
        System.out.println(length);
    }
}
