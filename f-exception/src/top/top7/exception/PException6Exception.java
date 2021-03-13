package top.top7.exception;

/******
 *       Created by LEARNING on 2020/10/28 14:07.
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
 * 自定义异常类:
 * 1. 自定义编译时异常 继承 Exception
 * 2. 自定义运行时异常 继承 RuntimeException
 * 3. 提供无参及string参数的两个构造方法
 */
public class PException6Exception extends RuntimeException {
    public static void main(String[] args) {
        throw new PException6Exception("我是异常描述信息");
    }

    public PException6Exception() {
    }

    public PException6Exception(String message) {
        super(message);
    }
}
