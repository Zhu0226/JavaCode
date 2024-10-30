package com.itheima.capsulation;

public class Student {
    String name;
    // 1、如何隐藏：使用private关键字(私有，隐藏)修饰成员变量，就只能在本类中被直接访问，
    // 其他任何地方不能直接访问。
    private int age;
    private double chinese;
    private double math;

    // 2、如何暴露（合理暴露）：使用public修饰（公开）的get和set方法合理暴露
    // 成员变量的取值和赋值。
    public void setAge(int age){  // 为年龄赋值
        if(age > 0 && age < 200){
            this.age = age;
        }else {
            System.out.println("您赋值的年龄数据非法！");
        }
    }

    public int getAge(){  // 获取年龄
        return age;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getChinese() {
        return chinese;
    }

    public void printAllScore(){
        System.out.println(name + "的总成绩是：" +
                (chinese + math));
    }

    public void printAverageScore(){
        System.out.println(name + "的平均成绩是：" +
                (chinese + math) / 2);
    }
}
