package top.top7;

/******
 *       Created by LEARNING on 2020/11/8 2:57.
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
import java.util.ArrayList;
import java.util.List;

/**
 * 拷贝某文件夹下的所有内容,使用多线程方式
 */
public class PCopyFile4 {
    public static void main(String[] args) {

        try {
            copyFile("F:\\QianFeng\\work", "I:/top");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //存放复制文件的线程对象
    private static List<Thread> threadList = new ArrayList<>();

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

        //记录粘贴位置文件夹的初始大小
        long l = dirSize(newDirFile);

        //调用进度监控方法,启动守护线程,动态监控拷贝进度
        thread(oldFile, newDirFile, 1000L);

        copy(oldFile, newDirFile.getAbsolutePath());

        System.out.println("共创建了" + threadList.size() + "个线程");

        //将复制文件的线程加入当前线程,等所有文件复制线程都结束后,当前线程再继续向下执行
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //检查此次拷贝任务的完整性
        if (dirSize(oldFile) == dirSize(newDirFile) - l) {
            System.out.println("拷贝完成!!!");
        } else {
            throw new IOException("此次拷贝任务已经完成,但拷贝文件与原文件的大小不一致,请检查数据是否完整...");
        }
    }


    /**
     * 内部递归调用  遍历文件夹  创建线程复制文件(一个文件一个线程)
     *
     * @param file
     * @param newDirPath 粘贴位置的文件夹String类型绝对路径
     * @throws IOException
     */
    private static void copy(File file, String newDirPath) throws IOException {
        if (file.isFile()) {
            CopyFileThread copyFileThread = new CopyFileThread(file, newDirPath);
            copyFileThread.setName(file.getName());
            threadList.add(copyFileThread);
            copyFileThread.start();
        } else {
            File file1 = new File(newDirPath + "/" + file.getName());
            file1.mkdir();
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
                //long类型向float类型可以自动转型,不过有可能会损失精度
                float l = dirSize(oldFile);
                float l1 = dirSize(newDirFile);
                while (true) {
                    try {
                        //File对象一直是对应文件或文件夹的最新状态
                        System.out.println("当前进度为:" + ((dirSize(newDirFile) - l1) / l * 100) + "%,已经执行了: " +
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

/**
 * 文件拷贝线程类
 */
class CopyFileThread extends Thread {
    private File oldFile;
    private String newDirPath;

    public CopyFileThread(File oldFile, String newDirPath) {
        this.oldFile = oldFile;
        this.newDirPath = newDirPath;
    }

    @Override
    public void run() {
//        System.out.println("线程:" + this.getName() + "启动");
        try {
            copy();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("线程:" + this.getName() + "结束");
    }

    private void copy() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(oldFile);
        FileOutputStream fileOutputStream = new FileOutputStream(newDirPath + "/" + oldFile.getName());
        byte[] b = new byte[1024 * 1024];
        int count;
        while ((count = fileInputStream.read(b)) != -1) {
            fileOutputStream.write(b, 0, count);
        }

        fileOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();
    }
}