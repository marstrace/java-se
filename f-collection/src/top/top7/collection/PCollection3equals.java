package top.top7.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
/******
 *       Created by LEARNING on 2020/10/29 12:45.
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
 * Collection 接口之contains(), remove(); 方法实现原理
 *
 * contains 与remove  方法底层都调用了 equals()方法来判断是否是同一个对象,因此需要重写集合元素类的equals方法
 */
public class PCollection3equals {
    public static void main(String[] args) {
        Collection<User> users = new ArrayList<>();
        users.add(new User("张三"));
        users.add(new User("李四"));
        users.add(new User("王五"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));
        users.add(new User("赞达亚"));

        boolean 李四 = users.contains(new User("李四"));
        System.out.println(李四);

        boolean 王五 = users.remove(new User("王五"));
        System.out.println(王五);

        System.out.println(users.size());
    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    //重写equals方法,自定义相等策略
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
}

