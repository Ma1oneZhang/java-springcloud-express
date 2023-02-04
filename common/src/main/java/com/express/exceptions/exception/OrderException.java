package com.express.exceptions.exception;

import com.express.enums.ResultCode;

public class OrderException extends BizException{
    public OrderException(ResultCode httpCodeEnum){
        super(httpCodeEnum);
    }

}
