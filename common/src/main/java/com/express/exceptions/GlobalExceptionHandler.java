package com.express.exceptions;

import com.express.enums.ResultCode;
import com.express.exceptions.exception.SystemException;
import com.express.exceptions.exception.UserException;
import com.express.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){
        //打印异常信息
        log.error("出现了应用异常:",e);
        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(ResultCode.UNKNOWN_EXCEPTION.getCode(), ResultCode.UNKNOWN_EXCEPTION.getMsg());
    }
    @ExceptionHandler(UserException.class)
    public ResponseResult userExceptionHandler(UserException e){
        //打印异常信息
        log.info("用户异常:" + e.getMessage());
        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e) {
        return ResponseResult.okResult(e.getCode(), e.getMsg());
    }

    // validate 验证
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult validateExceptionHandler(MethodArgumentNotValidException e){
        //打印异常信息
        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        log.error("出现了异常!:",e);
        if (ResultCode.AUTHOR_BLANK.getMsg().equals(msg)) {
            return ResponseResult.errorResult(ResultCode.AUTHOR_BLANK);
        } else if (ResultCode.CODE_BLANK.getMsg().equals(msg)) {
            return ResponseResult.errorResult(ResultCode.CODE_BLANK);
        } else if (ResultCode.PROBLEM_BLANK.getMsg().equals(msg)) {
            return ResponseResult.errorResult(ResultCode.PROBLEM_BLANK);
        }
        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(ResultCode.UNKNOWN_EXCEPTION.getCode(),e.getMessage());
    }
}