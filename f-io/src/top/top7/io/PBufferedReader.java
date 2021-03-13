package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/1 17:34.
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * bufferedReader:自带缓冲区的字符输入流
 * 1. 使用这个流不需要自己创建字节 或字符数组来缓冲存储数据
 */
public class PBufferedReader {

    public static void main(String[] args) throws IOException {

        //当一个流的构造方法中需要一个流的时候,这个被传进来的流叫做:节点流
        //外部负责包装的流叫做:包装流 或者 处理流
        //当前程序中FileReader就是节点流, BufferedReader就是包装流/处理流
        FileReader fileReader = new FileReader("f-io/src/tempfile4");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        //使用BufferedReader方法一次读取一个文本行,文本不带换行符
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println("长度为:"+s.length()+s);
        }
        //关闭流
        //对于包装流来说,只需要关闭最外层的流,里边的流会自动关闭
        bufferedReader.close();
    }
}
