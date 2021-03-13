package top.top7.enumeration;

/******
 *       Created by LEARNING on 2020/10/27 13:55.
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

/**
 * 枚举  enum
 */
public class PEnum1 {
    public static void main(String[] args) {
        System.out.println(Result.SUCCESS);
        System.out.println(Result.FAIL);
    }

    /**
     * 枚举类型的使用
     * @param a
     * @param b
     * @return 该方法只能返回枚举类型Result中的常量
     */
    Result test1(int a,int b){
        try {
            int c = a/b;
            return Result.SUCCESS;
        }catch (Exception e){
            return Result.FAIL;
        }
    }
}

/**
 * 枚举:一枚一枚可以列举出来时,才建议使用枚举类型
 * 枚举编译之后也是.class文件
 * 枚举也是一种引用数据类型
 * 枚举中的每一个值可以看做是"常量"
 */
//枚举类型的定义
enum Result {
    //SUCCESS FAIL 分别是枚举Result类型中的一个值
    //枚举中的每一个值可以看做是"常量"
    SUCCESS, FAIL
}