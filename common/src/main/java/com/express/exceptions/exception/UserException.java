package com.express.exceptions.exception;

import com.express.enums.ResultCode;

public class UserException extends BizException{
    public UserException(ResultCode httpCodeEnum) {
        super(httpCodeEnum);
    }
}
