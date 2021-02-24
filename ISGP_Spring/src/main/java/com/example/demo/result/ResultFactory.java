package com.example.demo.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultFactory {

    static Logger logger= LoggerFactory.getLogger("ResultFactory.class");
    public static <E> Result ResponseResult(ResultCode resultCode,E data){
        return new Result(resultCode.getCode(), resultCode.getMessage(),data);
    }
    public static <E> Result ResponseResult(int resultcode, String message, E data){
        return new Result<E>(resultcode,message,data);
    }
    public static <E> Result ResponseFail(E data){return ResponseResult(ResultCode.FAIL.getCode(),"失败",data);
    }
    public static <E> Result ResponseSuccess(E data){
        return ResponseResult(ResultCode.SUCCESS.getCode(),"成功",data);
    }
}
