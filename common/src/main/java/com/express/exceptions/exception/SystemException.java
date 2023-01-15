package com.express.exceptions.exception;
import com.express.enums.ResultCode;

public class SystemException extends BizException{

    public SystemException(ResultCode httpCodeEnum) {
        super(httpCodeEnum);
    }
}
