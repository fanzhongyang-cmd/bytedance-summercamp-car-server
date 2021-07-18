package com.example.cartype.util;

public class JsonResult<T> {
    private T data;
    private int code;

    public JsonResult(T data, int code) {
        this.data = data;
        this.code = code;
    }

    public JsonResult(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
