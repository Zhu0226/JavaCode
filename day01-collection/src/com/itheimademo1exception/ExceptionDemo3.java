package com.itheimademo1exception;

import java.sql.SQLOutput;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        //认识自定义常量
        System.out.println("程序开始了");
        try {
            saveAge(300);
        } catch (ItheimaAgeIllegalException e) {
            throw new RuntimeException(e);
        }
        System.out.println("程序失败了");
    }

    //需求：我们公司的系统只要收到了年龄小于1岁大于200的岁就是一个年龄非法异常。
public static void saveAge()throws ItheimaAgeIllegalException {
    saveAge(1);
}

    //需求：我们公司的系统只要收到了年龄小于1岁大于200的岁就是一个年龄非法异常。
    public static void saveAge(int age)throws ItheimaAgeIllegalException{
        if(age <1 || age > 200) {
        }    else {
            System.out.println("年龄非法");
            System.out.println("保存年龄" + age);
        }
    }
}
