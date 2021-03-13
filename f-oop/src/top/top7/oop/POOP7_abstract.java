package top.top7.oop;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/8 15:07.
 *
 * ********************************
 *
 * @author top234
 *
 *         抽象类(abstract class):
 *         1.抽象类使用abstract修饰
 *         2.抽象类不能实例化
 *         3.abstract 与 final不能同时使用
 *         4.抽象类有构造方法,但是不能实例化,抽象类的构造方法是给子类来使用的
 *         5.抽象方法:使用abstract修饰,并且没有方法体
 *         6.抽象类中可以没有抽象方法,但抽象方法必须在抽象类中定义(或接口中)
 *         7.一个非抽象的类继承抽象类,必须重写(实现)抽象类中的抽象方法
 */
public class POOP7_abstract {

}

abstract class Test3 {
    private final int a = 2;

    public Test3() {
        //抽象类有构造方法,但是不能实例化,抽象类的构造方法是给子类来使用的
    }

    final void t1() {

    }

    /**
     * 抽象方法:
     * 使用abstract修饰,并且没有方法体
     */
    abstract void t2();
}