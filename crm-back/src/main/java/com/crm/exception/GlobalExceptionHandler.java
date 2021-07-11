package com.crm.exception;


import com.crm.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public AjaxResponse defaultErrorHandler(HttpServletRequest request, Exception e){
        log.info("开始输出错误信息：");
        e.printStackTrace();
        if(e instanceof NoHandlerFoundException){
            log.info("没有找到匹配的url");
            return AjaxResponse.error(new CustomError(CustomErrorType.PAGE_NOT_FOUND_ERROR,e.getMessage()));
        }else if(e instanceof MaxUploadSizeExceededException) {
            log.info("文件超出指定大小异常");
            return AjaxResponse.error(new CustomError(CustomErrorType.FILE_MAX_ERROR, e.getMessage()));
        }
        return AjaxResponse.error(new CustomError(CustomErrorType.SYSTEM_ERROR,""));
    }
}