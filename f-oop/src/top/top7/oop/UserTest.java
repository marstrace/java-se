package top.top7.oop;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/5 23:00.
 *
 * ********************************
 *
 * @author top234
 */
public class UserTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        User alex = new User(25, "alex", false);
        Object clone = alex.clone();
        System.out.println(clone == alex);
        System.out.println(clone.equals(alex));
        System.out.println((new Object().hashCode()) == (new Object().hashCode()));
        System.out.println((new User().hashCode()) == (new User().hashCode()));
        T t = new T();
    }
}

/**
 * 实例变量的默认初始化是在什么时候完成的?
 */
class T {
    int a;

    {
        System.out.println(a);
    }

    public T() {
        a = 2;
        System.out.println(a);
    }
}
