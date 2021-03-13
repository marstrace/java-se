package top.top7;

/******
 *       Created by LEARNING on 2020/11/1 18:57.
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
import java.io.IOException;

/**
 * File:
 * 1. File类和四大家族没有关系,所以File类不能完成文件的读和写
 * 2. File对象代表文件和目录路径的抽象表示形态,一个file对象有可能对应的是目录,也可能是文件
 * 如:   H:/Idea破解包-激活码/idea激活码-山东理工大学.txt
 * 如:   C:/java/jdk15/conf
 *
 * File只是一个路径名的抽象表示形式,File对象与自己表示的文件或文件夹保持实时同步
 *
 * File类中的常用方法:
 * 1. exists();boolean 判断当前File对象是否存在对应的文件或文件夹
 * 2. createNewFile();boolean 以文件的形式创建,创建失败则返回false,之间已经存在也会创建失败
 * 3. mkdir();boolean 以目录的形式创建
 * 4. mkdir();boolean 以多重目录的形式创建
 * 5. getParent();String 获取文件父路径
 * 6. getParentFile();File 获取文件父路径File对象
 * 7. getAbsolutePath();String 获取绝对路径
 * 8. delete();boolean 删除文件或文件夹,但只能删除空文件夹,文件夹内若有内容则会删除失败
 * 9. getName();String 获取文件或文件夹name
 * 10. isDirectory();boolean 判断是不是一个目录
 * 11. isFile();boolean 判断是不是一个文件
 * 12. lastModified():long 最后一次修改的时间,long类型毫秒值,1970-1-1 00:00
 * 13. renameTo(File f);Boolean 修改文件或文件夹名称(文件或文件夹名称包括:存放路径+name),参数为File类实例,实例的构造参数为重命名文件的新name以及新存放路径
 *      但新存放路径必须存在(且新的存放位置不能够跨盘符,I盘只能重命名到I盘,同一磁盘应该不涉及数据在硬盘中存储位置的移动,只是修改了映射路径),若修改的是文件夹,则会将整个文件夹进行移动(但文件夹下只能存在文件,不能存在文件夹)
 * 14. listFiles();File[] 获取当前文件夹下的所有文件和文件夹
 */
public class PFile1 {
    public static void main(String[] args) throws IOException {

        File file = new File("I:/file");
        //1. exists 判断是否存在
        boolean exists = file.exists();
        System.out.println(exists);

        //2. 以文件的形式创建
        boolean newFile = file.createNewFile();
        System.out.println(file.exists());

        File file1 = new File("I:/top");
        //3. 以目录的形式创建
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir);

        File file2 = new File("I:/top/top/top/d");
        //4. 创建多重目录
        boolean mkdirs = file2.mkdirs();

        //5. 获取文件父路径
        String parent = file2.getParent();
        System.out.println(parent);

        //6. 获取文件父路径File对象
        File parentFile = file2.getParentFile();
        System.out.println(parentFile);

        //7. 获取绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        //8. 删除文件或目录
//        boolean delete1 = file.delete();
//        System.out.println(delete1);
        boolean delete = file1.delete();
        System.out.println(delete);
        boolean delete2 = file2.delete();
        System.out.println(delete2);

        //9. 获取文件或文件名
        String name = file.getName();
        System.out.println(name);

        //10 判断是否是一个目录,注意若被删除了,就不是了
        boolean directory = file2.isDirectory();
        System.out.println(directory);

        //11. 判断是否是一个文件
        boolean file3 = file.isFile();
        System.out.println(file3);

        //12. 获取最后一次修改时间
        long l = file.lastModified();
        System.out.println(l);

        //13. 重命名文件或目录, file实例的构造参数为文件的新name及存放位置
        // 修改成功时返回值为true,失败及名称未改变都返回false
        boolean b = file.renameTo(new File("I:/hah"));

        //14. 获取当前目录下的所有子目录及文件
        File file4 = new File("I:");
        File[] files = file4.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
