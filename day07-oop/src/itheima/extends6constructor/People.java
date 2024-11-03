package itheima.extends6constructor;
// 父类
// 继承的好处：1.代码复用 2.减少了重复代码。
public class People {
    private String name;
    private char sex;

    public People() {
    }

    public People(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}