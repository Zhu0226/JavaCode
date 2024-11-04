package com.itheimademo1exception;

/**
 * 创建一个自定义异常类
 *1.继承Exception
 * 2.重写Exception的构造器
 * 3.哪里需要用这个异常返回，哪里就throw
 */

public class ItheimaAgeIllegalException extends Throwable {

    public ItheimaAgeIllegalException(){
    }

    public ItheimaAgeIllegalException(String message) {
        super();
    }

}
