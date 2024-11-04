package com.itheimademo1exception;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        //认识自定义异常，运行时异常
        System.out.println("程序开始了");
            saveAge(300);
        System.out.println("程序失败了");
    }

    //需求：我们公司的系统只要收到了年龄小于1岁大于200的岁就是一个年龄非法异常。
    public static void saveAge(int age){
        if(age <1 || age > 200) {
            //年龄非法，抛出一个异常
            throw new ItheimaAgeIllegalRuntimeException("年龄非法");
        }    else {
            System.out.println("年龄非法");
            System.out.println("保存年龄" + age);
        }
    }
}
