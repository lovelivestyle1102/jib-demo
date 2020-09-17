package com.utry.common.bean;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020/8/31
 * Time: 11:12 上午
 * Description:
 *
 * @author yangchenglong
 */
@Data
//@ApiModel(description = "该实体为api接口统一返回封装类")]
@Schema(description = "封装统一返回实体类") public class CommonResponse<T> implements Serializable {

    //      @ApiModelProperty(name = "code",notes = "响应编码",dataType = "int")
    @Schema(description = "请求响应编码") private int code;

    //      @ApiModelProperty(name = "message",notes = "响应消息",dataType = "string")
    @Schema(description = "请求响应消息") private String message;

    //      @ApiModelProperty(name = "data",notes = "响应结果")
    @Schema(description = "该次请求的真实结果实体类") private T data;

    //      @ApiModelProperty(name = "count",notes = "当请求接口为列表是，该字段才会有意义。该字段代表总数",dataType = "int")
    @Schema(description = "当请求接口为列表是，该字段才会有意义。该字段代表总数") private int count;

    public CommonResponse() {

    }

    public CommonResponse(int code, String message) {
        this(code, message, null, 0);
    }

    public CommonResponse(int code, String message, T data) {
        this(code, message, data, 0);
    }

    public CommonResponse(int code, String message, T data, int count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public static CommonResponse buildFailBean(int code, String message) {
        return new CommonResponse(code, message);
    }

    public static CommonResponse buildFailBean(String message) {
        return new CommonResponse(4000, message);
    }

    public static CommonResponse buildBusinessFailBean(String message) {
        return new CommonResponse(5000, message);
    }

    public static CommonResponse buildValidateParamFailBean(String message) {
        return new CommonResponse(6000, message);
    }

    public static CommonResponse buildSuccessBean(String message) {
        return new CommonResponse(2000, message);
    }

    public static <T> CommonResponse buildSuccessBean(String message, T data) {
        return new CommonResponse(2000, message, data);
    }

    public static <T> CommonResponse buildSuccessBean(String message, T data, int count) {
        return new CommonResponse(2000, message, data, count);
    }

    public static <T> CommonResponse buildSuccessBean(T data) {
        return new CommonResponse(2000, "请求成功！", data, 0);
    }
}
