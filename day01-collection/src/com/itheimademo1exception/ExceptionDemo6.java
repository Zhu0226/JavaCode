package com.itheimademo1exception;

import java.util.Scanner;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        // 目标：掌握异常的处理方案2,捕获住异常对，尝试重新修复。
        //接收一个商品定价
        System.out.println("欢迎使用商品管理系统");
        ;

        while (true) {
            try {

                double price = uesrInputPrice();
                System.out.println("您输入的价格是：" + price);
                break;
            } catch (Exception e) {
                System.out.println("您输入的价格有误，请重新输入！");
            }
        }

        System.out.println("谢谢使用，欢迎下次再来！");
    }
    public static double uesrInputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品价格：");
        double price = sc.nextDouble();
        return price;
    }
}
