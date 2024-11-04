package com.itheimademo1exception;

/**
 * 创建一个自定义异常类
 *1.继承RuntimeException
 * 2.重写RuntimeException的构造器
 * 3.哪里需要用这个异常返回，哪里就throw
 */

public class ItheimaAgeIllegalRuntimeException extends RuntimeException {

    public ItheimaAgeIllegalRuntimeException() {
    }

    public ItheimaAgeIllegalRuntimeException(String message) {

        super();
    }
}