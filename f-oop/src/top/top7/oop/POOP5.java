package top.top7.oop;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/4 0:43.
 *
 * ********************************
 *
 * @author top234
 *
 *         重写Object类的toString()方法
 */
public class POOP5 {


    public static void main(String[] args) {
        POOP5 poop5 = new POOP5();
        System.out.println(poop5);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());

        //System.out.println(this);this关键字代表当前对象,println()方法在打印一个对象时会调用String类的valueOf()方法,
        // 而String类重载的静态方法valueOf()方法中参数为引用类型时会调用该实例的toString()方法,因此此处会出现死递归,最终
        // 会报java.lang.StackOverflowError(堆栈溢出错误)错误

        return "this is an object for POOP5 class";
    }
}
