package com.livre.myhome.result;

public class Result {


    public int code;
    public String message;
    public Object result;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
    public Result(int code) {
        this.code = code;
    }
}
