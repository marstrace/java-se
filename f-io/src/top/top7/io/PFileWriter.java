package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/1 16:54.
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

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter:文件字符输出流
 * 1. 只能输出纯文本文件,word不是纯文本文件
 */
public class PFileWriter {
    public static void main(String[] args) {
        FileWriter fw = null;

        try {
            //创建文件字符输出流对象
            fw = new FileWriter("f-io/src/tempfile3", true);

            //写入单个字符编码
            fw.write(25684);

            //写入字符数组
            fw.write(new char[]{'中', '山', '天', '曌'});


            //写入字符串,并使用换行符换行 \n
            fw.write("\n这是通过什么字符编码集写的呢?",0,9);


            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
