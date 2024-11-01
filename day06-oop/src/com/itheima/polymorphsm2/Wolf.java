package com.itheima.polymorphsm2;

public class Wolf extends Animal {
    String name = "狼";

    @Override
    public void run() {
        System.out.println("🐺跑的贼溜~~~");
    }

    public void eatSheep() {
        System.out.println("狼吃羊");
    }
}
