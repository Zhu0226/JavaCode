package com.itheima.extends2modifer;

public class Test {
    public static void main(String[] args) {
        // 目标：认识四种权限修饰符的修饰范围。
        Fu fu = new Fu();
        // fu.privateMethod();
        fu.method();
        fu.protectedMethod();
        fu.publicMethod();
    }
}
