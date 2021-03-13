package top.top7.oop;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/8 12:01.
 *
 * ********************************
 *
 * @author top234
 *
 *         final 关键字:
 *         1.修饰类,无法被继承
 *         2.修饰局部变量,无法被改变(常量,不能二次赋值)
 *         3.修饰属性,没有默认值,必须手动赋值(可以在声明时赋值,也可以在代码块与构造方法中赋值),无法被改变(常量,不能二次赋值)
 *         4.修饰方法,无法被子类重写
 */
public final class Keyword4_final {
    public static void main(String[] args) {

    }
}

class Test1 {
    static final int a;

    static {
        a = 4;
    }

    public Test1() {
//        a = 5;
    }

    final void m1() {
        final int b = 1;
    }
}
