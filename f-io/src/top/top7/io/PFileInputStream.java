package top.top7.io;

/******
 *       Created by LEARNING on 2020/10/31 18:11.
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 在Idea中,默认当前路径为项目的根目录(注意区分模块根目录与项目根目录)
 *
 * java.io.FileInputStream:
 * 1. 文件字节输入流,万能的,任何类型的文件都可以采用这个流来读
 * 2. 字节的方式,完成输入操作,完成读的操作(硬盘--->内存)
 *
 * FileInputStream的常用方法:
 * 1. read();
 * 2. read(byte[]);
 * 3. close();
 * 4. avaliable();返回流当中剩余没有读到的字节数量
 * 5. skip();跳过几个字节不读
 *
 */
public class PFileInputStream {

    /**
     * 最终版:
     * 使用FileInputStream一次读取一个字节数组
     */
    public static void test2() {
        FileInputStream fis=null;
        try {
            fis = new FileInputStream("f-io/src/tempfile1");
            byte[] b = new byte[5];

            int count;
            //count为 读到的字符个数,若读到文件末尾则返回 -1
            while ((count = fis.read(b)) != -1) {
                System.out.print(new String(b, 0, count));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    //流用完后一定要进行关闭
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        test2();
//        System.out.println(new String(new char[]{'中','杨','林'}).getBytes().length);
    }

    /**
     * 使用FileInputStream一次读取一个字节
     * 内存磁盘交互频繁,效率低
     */
    public static void test1() {
        FileInputStream fis = null;
        //创建流
        try {
            fis = new FileInputStream("I:/test/t");
            int b;
            //循环读取字节并输出,每次循环读取一个字节,硬盘和内存交互次数过多,效率太低
            while ((b = fis.read()) != -1) {
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    //关闭流
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
