package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/1 16:26.
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
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader:文件字符输入流
 * 1. 只能读取纯文本,读取文本时比较方便快捷
 */
public class PFileReader {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            //创建文件字符输入流对象
            reader = new FileReader("f-io/src/tempfile1");
            char[] chars = new char[20];
            int count;
            while ((count = reader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, count));
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
