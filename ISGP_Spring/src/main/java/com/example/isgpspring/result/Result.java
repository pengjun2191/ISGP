package com.example.isgpspring.result;
/*
 *
 * @param null
 * @return
 * @author pengjun
 * @date 2020/12/3 19:30
 */
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
