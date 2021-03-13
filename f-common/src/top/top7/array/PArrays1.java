package top.top7.array;

/******
 *       Created by LEARNING on 2021/2/23 20:05.
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

import java.util.Arrays;

/**
 * 关于java.util.Arrays 工具类的使用
 */
public class PArrays1 {
    /**
     * 数组属性的默认初始值为 null
     */
    static double[] doubles;

    public static void main(String[] args) {
        //数组拷贝
        String[] objects = new String[20];
        String[] objects1 = Arrays.copyOf(objects, objects.length);
        System.out.println(objects == objects1);
        //输出
        System.out.println(Arrays.toString(objects));
        //比较两个数组是否完全相等
        System.out.println(Arrays.equals(objects, objects1));

        System.out.println(doubles == null);
    }
}
