package top.top7;

/******
 *       Created by LEARNING on 2020/11/2 13:48.
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

import java.io.*;

/**
 * 拷贝某文件夹下的所有内容,并创建守护线程实时检测copy进度
 *
 * 注意:long类型为整型,做除法运算需转为浮点型
 * 注意:File对象一直是对应文件或文件夹的最新状态,就算是写入一半的文件也可以映射到
 */
public class PCopyFile3 {
    public static void main(String[] args) {

        try {
            copyFile("I:\\迅雷下载\\euphoria", "I:/top");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过String 路径copy文件或文件夹
     *
     * @param oldFileName 要复制的文件路径
     * @param newDirName  要粘贴的文件夹,若不存在则创建
     * @throws IOException
     */
    public static void copyFile(String oldFileName, String newDirName) throws IOException {
        copyFile(new File(oldFileName), new File(newDirName));
    }


    /**
     * 通过File对象copy文件或文件夹
     *
     * @param oldFile    要复制的文件对象
     * @param newDirFile 粘贴的文件夹对象
     * @throws IOException
     */
    public static void copyFile(File oldFile, File newDirFile) throws IOException {
        if (!oldFile.exists()) throw new FileNotFoundException("文件或文件夹不存在");
        if (!newDirFile.exists() && !newDirFile.mkdirs()) throw new FileNotFoundException("文件夹未创建成功");

        //调用进度监控方法,启动守护线程,动态监控拷贝进度
        thread(oldFile, newDirFile, 1000L);

        copy(oldFile, newDirFile.getAbsolutePath());

        //检查此次拷贝任务的完整性
        if (dirSize(oldFile) == dirSize(newDirFile)) {
            System.out.println("拷贝完成!!!");
        } else {
            throw new IOException("此次拷贝任务已经完成,但拷贝文件与原文件的大小不一致,请检查数据是否完整...");
        }
    }


    /**
     * 内部递归调用  遍历复制文件夹
     *
     * @param file
     * @param newFile
     * @throws IOException
     */
    private static void copy(File file, File newFile) throws IOException {
        if (file.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile.getAbsolutePath() + "/" + file.getName());
            byte[] b = new byte[1024 * 1024];
            int count;
            while ((count = fileInputStream.read(b)) != -1) {
                fileOutputStream.write(b, 0, count);
            }
            System.out.println("文件:" + file.getAbsolutePath() + "---->" + newFile.getAbsolutePath() + "  >>SUCCESS");
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } else {
            File file1 = new File(newFile.getAbsolutePath() + "/" + file.getName());
            file1.mkdir();
            System.out.println("文件夹:" + file1.getAbsolutePath() + "创建成功");
            File[] files = file.listFiles();
            for (File f : files) {
                copy(f, file1);
            }
        }
    }

    /**
     * 优化: ---> 内部递归调用  遍历复制文件夹
     * 修改粘贴位置文件夹 File参数对象 为 文件夹字符串路径参数,减少递归调用时因newDirFile对象保持所产生的内存开销
     *
     * 不过好像其实并没有什么作用? 方法未结束,局部变量还是还会保持的
     *
     * @param file
     * @param newDirPath 粘贴位置的文件夹String类型绝对路径
     * @throws IOException
     */
    private static void copy(File file, String newDirPath) throws IOException {
        if (file.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(newDirPath + "/" + file.getName());
            byte[] b = new byte[1024 * 1024];
            int count;
            while ((count = fileInputStream.read(b)) != -1) {
                fileOutputStream.write(b, 0, count);
            }
//            System.out.println("文件:" + file.getAbsolutePath() + "---->" + newDirPath + "  >>SUCCESS");
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } else {
            File file1 = new File(newDirPath + "/" + file.getName());
            file1.mkdir();
//            System.out.println("文件夹:" + file1.getAbsolutePath() + "创建成功");
            File[] files = file.listFiles();
            for (File f : files) {
                copy(f, file1.getAbsolutePath());
            }
        }
    }

    /**
     * 创建守护线程动态检测文件拷贝进度
     *
     * @param oldFile
     * @param newDirFile
     * @param millis     刷新拷贝进度的间隔时间
     */
    private static void thread(File oldFile, File newDirFile, long millis) {
        Thread t = new Thread() {
            @Override
            public void run() {
                long timeMillis = System.currentTimeMillis();
                float l = (float) dirSize(oldFile);
                while (true) {
                    try {
                        //File对象一直是对应文件或文件夹的最新状态
                        System.out.println("当前进度为:" + (dirSize(newDirFile) / l * 100) + "%,已经执行了: " +
                                (System.currentTimeMillis() - timeMillis) + "毫秒");

                        sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        System.out.println("拷贝进度检测代码出问题了");
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }

    /**
     * 递归遍历获取文件夹的大小(文件夹内所有文件大小之和)
     */
    private static long dirSize(File file) {
        long size = 0;
        if (file.isFile()) {
            size = file.length();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                size += dirSize(f);
            }
        }
        return size;
    }
}
