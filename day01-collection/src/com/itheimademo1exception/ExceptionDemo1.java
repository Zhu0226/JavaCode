package com.itheimademo1exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        //认识异常的体系，搞清楚的基本作用。
        show();
        show1();
    }


    //定义一个方法认识编译时异常
    public static void show1(){
        System.out.println("show1方法执行了");
        //编译时异常的特点，编译时异常，必须处理。
        //String str = "2024-10-09 16:16:32;
        //把字符串解析成一个Java中的一个日期对象
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date date = sdf.parse(str);
        System.out.println();
    }
    //定义一个方法认识运行异常。
    public static void show(){
        //运行时异常的特点是编译时不报错，运行时报错。继承于自RuntimeException
        System.out.println("运行开始了");
        int[] arr = {1,2,3};
        //System.out.println(arr[3]);     //ArrayIndexOutOfBoundsException
        //System.out.println("show方法执行完毕。");

        //System.out.println(10/0);       //ArrayIndexOutOfBoundsException

        //空指针异常
        //String str = null;
        //System.out.println(str);
        //System.out.println(str.length());   //NullPointerException
        //System.out.println("show方法执行完毕。");
    }
}
