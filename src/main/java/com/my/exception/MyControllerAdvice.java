package com.my.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@ResponseBody
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandle(Exception ex) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", -1);
        hashMap.put("msg", ex.getMessage());
        return hashMap;
    }

    /**
    * 方法实现说明
    * @author   luqihua
     * @param null
    * @return
    * @date     2019/4/25 0:05
    */
    @ExceptionHandler(value = BusinessException.class)
    public Map<String, Object> errorHandle(BusinessException e) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", e.getCode());
        hashMap.put("msg", e.getMsg());
        return hashMap;
    }
}
