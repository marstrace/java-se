package top.top7.annotation;

/******
 *       Created by LEARNING on 2021/1/24 1:36.
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

import top.top7.annotation.myannotation.MyAnnotation1;
import top.top7.annotation.myannotation.MyAnnotation2;

/**
 * 1.元注解: 用来标注"注解类型"的"注解"称为元注解
 * 2.常见的元注解: @Target @Retention
 * 3. @Target : 用来标注"被注解"的"注解"可以出现的位置
 *
 * @Target(ElementType.METHOD) :表示"被标注"的"注解"只能出现在方法上
 *
 * 4. @Retention: 用来标注 "被标注"的"注解"最终保存的位置
 * @Retention(RetentionPolicy.SOURCE): 表示该注解只被保留在java源文件中
 * @Retention(RetentionPolicy.CLASS): 表示该注解被保存在class文件中
 * @Retention(RetentionPolicy.RUNTIME): 表示该注解被保存在class文件中, 并可以被反射机制获取到
 */
@MyAnnotation2
public class PAnnotation2 {
    /**
     * @MyAnnotation2 因使用元注解@Target对@MyAnnotation2使用位置进行了限制,因此该注解不能不能出现在构造方法上
     */
    public PAnnotation2() {

    }

    @MyAnnotation1(1235)
    int age;
}
