package com.utry.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/9/7
 * Time: 4:57 下午
 * Description: 
*/
@Data
public class StudentUpdateBean implements Serializable {

    @Schema(description = "学生编号")
    @NotNull(message = "请输入学生编号！")
    private Integer id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名信息不能为空")
    @Schema(description = "学生信息",required = true,maxLength = 20)
    private String name;

    /**
     * 年龄
     */
    @Max(value = 200,message = "年龄最大200")
    @Min(value = 0,message = "年龄最小为0")
    @Schema(description = "年龄",maximum = "200",minimum = "0")
    private Integer age;

    /**
     * 地址
     */
    @Length(max = 500,message = "输入限制最大长度为500")
    @Schema(description = "地址",maxLength = 500)
    private String address;
}
