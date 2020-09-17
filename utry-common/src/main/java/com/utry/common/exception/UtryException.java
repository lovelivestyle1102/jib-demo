package com.utry.common.exception;



/**
 * Created with IntelliJ IDEA.
 * Date: 2020/8/31
 * Time: 11:14 上午
 * Description: 质检业务异常封装类.
 * @author yangchenglong
 */

public class UtryException extends RuntimeException{

    private int code;

    private String message;

    public UtryException(int code ,String message){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
