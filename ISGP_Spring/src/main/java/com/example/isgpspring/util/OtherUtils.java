package com.example.isgpspring.util;

public class OtherUtils {
    public static Integer toPageNum(Integer pagenum){
        if (pagenum==null){
            return pagenum=0;
        }
    return pagenum-1;
    }
}
