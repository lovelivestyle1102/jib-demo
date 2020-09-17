package com.utry.model;

import lombok.Data;
import java.io.Serializable;

/**
 * t_student
 * @author 
 */
@Data
//@ApiModel("学生信息实体类")
public class TStudent implements Serializable {


//    @ApiModelProperty(notes = "编号")
    private Integer id;

    /**
     * 姓名
     */
//    @ApiModelProperty(notes = "姓名")
    private String name;

    /**
     * 年龄
     */
//    @ApiModelProperty(notes = "年龄")
    private Integer age;

    /**
     * 地址
     */
//    @ApiModelProperty(notes = "地址")
    private String address;

    private static final long serialVersionUID = 1L;
}