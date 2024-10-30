package com.itheima.javabean;

public class StudentOperator {
    private Student s; // 记住要操作的学生对象。
    public StudentOperator(Student s) {
        this.s = s;
    }
    public void printAllScore() {
        System.out.println(s.getName() + "总成绩是：" + (s.getMath() + s.getEnglish()));
    }

    public void printAverageScore() {
        System.out.println(s.getName() + "平均成绩是：" + (s.getMath() + s.getEnglish()) / 2);
    }
}
