package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/3 16:17.
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
import java.io.ObjectInputStream;

/**
 * ObjectInputStream:对象反序列化
 *
 * 反序列化: 读取序列化到文件中的对象
 */
public class PObjectInputStream {
    public static void main(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("f-io/src/student"));
        Object o = objectInputStream.readObject();
        Object o1 = objectInputStream.readObject();
        System.out.println(o.toString());
        System.out.println(o1.toString());
        objectInputStream.close();
    }
}
