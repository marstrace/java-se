package top.top7.oop;

import java.util.Objects;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/5 7:37.
 *
 * ********************************
 *
 * @author top234
 *
 *         自定义用户类 User,并重写Object类的 toString() equals() hashCode() clone()方法
 */
public class User implements Cloneable {
    private int id;
    private String name;
    private boolean gender;

    public User() {
    }

    public User(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 当属性为基本类型boolean时,idea的get方法默认生成模板中会将get方法生成为 "is变量名()"的形式,
     * 可选择使用自定义的get方法模板.(将默认模板复制一份,并修改其中关于boolean类型"is变量名"方法名为"get变量名 ")
     * 或直接使用包装类Boolean
     */
    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    /**
     * 深浅拷贝之浅拷贝:
     * 对象的克隆必须重写Object类的clone方法,并实现Cloneable接口
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                gender == user.gender &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender);
    }
}
