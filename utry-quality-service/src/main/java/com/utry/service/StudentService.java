package com.utry.service;

import com.utry.bean.StudentBean;
import com.utry.bean.StudentUpdateBean;
import com.utry.dtos.StudentDTO;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020/8/31
 * Time: 3:13 下午
 * Description:
 *
 * @author yangchenglong
 */
public interface StudentService {

    /**
     * 新增一学生信息
     *
     * @param student
     * @return
     */
    boolean createStudent(StudentBean student);

    /**
     * 根据编号查询学生信息.
     *
     * @param id 学生编号
     * @return
     */
    StudentDTO selectStudent(int id);

    /**
     * 更新学生信息.
     *
     * @param studentUpdateBean
     * @return
     */
    Boolean updateStudent(StudentUpdateBean studentUpdateBean);
}
