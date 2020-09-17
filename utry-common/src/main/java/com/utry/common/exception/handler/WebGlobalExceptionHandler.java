package com.utry.common.exception.handler;

import com.utry.common.bean.CommonResponse;
import com.utry.common.constant.ExceptionConstant;
import com.utry.common.exception.UtryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020/8/31
 * Time: 11:15 上午
 * Description: 对异常做统一处理.
 *
 * @author yangchenglong
 */

@RestControllerAdvice public class WebGlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(WebGlobalExceptionHandler.class);

    /**
     * 所有异常统一处理.
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class) public CommonResponse<String> handlerAllException(Exception exception) {
        logger.error("this is system error happen", exception);

        return CommonResponse.buildFailBean(ExceptionConstant.INTER_SYSTEM_ERROR_CODE, "系统异常请联系管理员！");
    }

    /**
     * 所有业务异常统一处理.
     *
     * @param utryException
     * @return
     */
    @ExceptionHandler(UtryException.class) public CommonResponse<String> handlerAllBusinessException(
        UtryException utryException) {

        return CommonResponse.buildFailBean(utryException.getCode(), utryException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();

        StringBuilder stringBuilder = new StringBuilder();

        for (FieldError fieldError : fieldErrors) {

            stringBuilder.append(fieldError.getField() + ", " + fieldError.getDefaultMessage()).append(";");

        }

        for (ObjectError objectError : globalErrors) {

            stringBuilder.append(objectError.getObjectName() + ", " + objectError.getDefaultMessage()).append(";");

        }

        return CommonResponse.buildFailBean(ExceptionConstant.PARAM_VALID_ERROR_CODE, stringBuilder.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResponse<String> handleConstraintViolatedException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            stringBuilder.append(constraintViolation.getMessage()).append(";");
        }
        return CommonResponse.buildFailBean(ExceptionConstant.PARAM_VALID_ERROR_CODE, stringBuilder.toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResponse<String> handleMissingServletRequestParameterException(
        MissingServletRequestParameterException ex) {

        String error = ex.getParameterName() + ", " + ex.getMessage();

        return CommonResponse.buildFailBean(ExceptionConstant.PARAM_VALID_ERROR_CODE, error);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public CommonResponse<String> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Unsupported content type: ").append(ex.getContentType()).append(", Supported content types: ").append(MediaType.toString(ex.getSupportedMediaTypes()));

        return CommonResponse.buildFailBean(ExceptionConstant.PARAM_VALID_ERROR_CODE, stringBuilder.toString());
    }

}
