package top.top7.io;

/******
 *       Created by LEARNING on 2020/11/2 18:46.
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
import java.util.Properties;

/**
 * Properties:属性配置文件类
 * Properties集合继承了HashTable集合,是线程安全的
 * Properties集合的key和value都只能是字符串类型
 *
 * Properties与IO流的联合使用
 */
public class IO_Properties {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("f-io/src/info.properties");
            Properties prop = new Properties();

            //调用properties集合的load(字符);方法,将文件中的数据加载到集合中
            prop.load(fis);
            String name = prop.getProperty("name");
            String pass = prop.getProperty("pass");

            System.out.println(name + "-------" + pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
