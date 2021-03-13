package top.top7.oop;

import org.junit.Test;

//1.对于非当前包下且非java.lang包下的类,在使用时需要使用import
// 关键字进行导入,或直接使用全限定类名
import java.util.List;
//2.静态导入:使用import + static关键字的方式可以导入一个类的静
// 态成员,导入后可直接使用,无需使用类名.静态成员的方式
import static java.util.Arrays.*;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/8 16:07.
 *
 * ********************************
 *
 * @author top234
 *
 *         接口(interface):
 *         1.接口是一种"引用数据类型",编译后同样生产.class文件
 *         2.接口是完全抽象的
 *         3.接口的定义: [修饰符列表] interface 接口名{}
 *         4.接口支持多继承,一个接口可以继承多个接口
 *         5.接口中只包含两个部分:常量  与  抽象方法
 *         6.接口中抽象方法都是(必须是)public abstract 修饰的
 *         7.接口中常量都是(必须是)public static final 修饰的
 *         8.public abstract 与  public static final 可以省略(写与不写都存在)
 *         9.接口支持多实现.一个类可以实现多个接口,非抽象类实现接口必须重写接口的抽象方法,抽象类实现接口可以不重写接口的抽象方法
 *         10.接口实现语法: class B implements 接口1,接口2...{}
 *         11.entends 和 implements 可以联合使用
 *         12.接口与接口之间的强制类型转换不需要有继承关系(可以正常编译,但在运行时若引用指向的对象不是当前变量的接口类型的实例则会报
 *         ClassCastException异常)
 *
 *         package 和 import:
 *         ...
 */
public class POOP8_interface implements A, C {
    @Test
    public void m1() {
        //调用接口中的常量
        System.out.println(A.CHANG_LIANG);
        System.out.println(B.CHANG_LIANG);
    }

    @Test
    public void m2() {
        A a = new POOP8_interface();
        C c = (C) a;
        List list;
        sort(new int[]{});
    }

    @Override
    public void f1() {

    }
}

interface A {
    /*public static final */ int CHANG_LIANG = 4;

    /*public abstract*/ void f1();
}

interface C {
}

abstract class B implements C, A {

}
