package top.top7.reflect;

/******
 *       Created by LEARNING on 2020/11/9 18:48.
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

import top.top7.bean.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 项目中文件的路径: 类路径(classpath: 字节码文件的加载路径)
 * 1. 不同IDE的默认路径可能不同,当一个项目进行了移植时就有可能获取不到在之前IDE默认路径下的文件
 * 2. 类路径是类的加载路径, 是项目的src文件夹下(编译器在编译时会将src下的文件复制到字节码文件的加载路径下)
 *
 * 1. 获取src下的文件的绝对路径:
 * 2. 获取类路径下的文件的输入流
 * 3. 通过当前类的Class类对象获取类加载器实例
 */
public class PReflect3ClassPath {
    public static void main(String[] args) {
        //1. 获取src下的文件的绝对路径:
//        Thread thread = Thread.currentThread();//当前线程对象
//        ClassLoader contextClassLoader = thread.getContextClassLoader();//当前线程的类加载器对象
//        URL resource = contextClassLoader.getResource("info.properties");//当前线程的类加载器默认从类的根路径下加载资源
//        String path1 = resource.getPath();//资源文件的绝对路径
        String path = Thread.currentThread().getContextClassLoader().getResource("info.properties").getPath();
        System.out.println(path);


        //2. 获取类路径下的文件的输入流
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("info.properties");

        //3. 通过当前类的Class类对象获取类加载器实例(
        // 只要是用 在当前类路径下的类的Class对象所获取到的类加载器实例都可以加载当前类路径下的文件)
        //当前类路径下只有一个类加载器实例
        InputStream resourceAsStream1 = top.top7.bean.User.class.getClassLoader().getResourceAsStream("info.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream1);
            String name = properties.getProperty("name");
            System.out.println(name);

            //关闭流,在属性配置文件的输入流被Properties实例加载后就可以关闭类
            resourceAsStream.close();
            resourceAsStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取到的都是同一个类加载器实例
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = PReflect3ClassPath.class.getClassLoader();
        ClassLoader classLoader1 = User.class.getClassLoader();
        System.out.println(classLoader == contextClassLoader);
        System.out.println(classLoader1 == contextClassLoader);
        System.out.println(classLoader1 == classLoader);


        //与上面不是同一个类加载器实例
        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader==classLoader2);
    }
}
