package com.utry.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/9/7
 * Time: 2:42 下午
 * Description: 
*/
@Data
public class StudentDTO implements Serializable {

    /**
     * 学生编号
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;
}
