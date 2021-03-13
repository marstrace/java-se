package top.top7.io;

/******
 *       Created by LEARNING on 2020/10/31 21:47.
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.FileOutputStream:
 * 1. 文件字节输出流
 * 2. 以字节的方式完成输出,写的操作,从内存到硬盘
 */
public class PFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileOutputStream fos2 = null;
        try {
            //若文件不存在则创建,文件夹不存在就会报异常java.io.FileNotFoundException
            //会先将原文件内容清空,再写入本次要写的内容
            fos = new FileOutputStream("f-io/src/tempfile2");
            fos.write(new byte[]{97, 99, 101, 103, 105});

            //使用构造参数传入不清空源文件,追加方式写内容
            fos2 = new FileOutputStream("f-io/src/tempfile3", true);
            fos2.write(new byte[]{97, 99, 101, 103, 105});

            //输出流一定要进行刷新,防止数据丢失
            fos.flush();
            fos2.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos2 != null) {
                try {
                    fos2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
