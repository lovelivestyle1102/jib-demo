package com.utry.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/8/31
 * Time: 3:11 下午
 * Description: 
*/
@Data
@Schema(name="StudentBean", description="学生信息请求bean")
public class StudentBean implements Serializable {

    @Schema(description = "学生编号")
    private Integer id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名信息不能为空")
    @Schema(description = "pet status in the store",required = true,maxLength = 20)
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
    @Schema(description = "pet status in the store",maxLength = 500)
    private String address;
}
