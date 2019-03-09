package com.example.zgq.error;

/**
 * 描述：业务异常
 * @author zgq
 * @date   2017/12/3
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){}

    public BusinessException(String message) {
        super(message);
    }
}
