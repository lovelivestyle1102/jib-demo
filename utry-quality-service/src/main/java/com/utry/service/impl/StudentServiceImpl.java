package com.utry.service.impl;

import com.utry.bean.StudentBean;
import com.utry.bean.StudentUpdateBean;
import com.utry.common.constant.ExceptionConstant;
import com.utry.common.exception.UtryException;
import com.utry.dtos.StudentDTO;
import com.utry.mapper.TStudentDao;
import com.utry.model.TStudent;
import com.utry.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * @author: yangchenglong
 * Date: 2020/8/31
 * Time: 3:14 下午
 * Description: 
*/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TStudentDao studentDao;

    /**
     *
     * 新增一学生信息.
     *
     * @param student
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override public boolean createStudent(StudentBean student) {

        TStudent tStudent = new TStudent();

        BeanUtils.copyProperties(student,tStudent);

        int addResult = studentDao.insertSelective(tStudent);

        return addResult > 0;
    }

    /**
     *
     * 根据编号查询学生信息.
     *
     * @param id 学生编号
     * @return
     */
    @Override public StudentDTO selectStudent(int id) {
        TStudent tStudent =  studentDao.selectByPrimaryKey(id);

        if(tStudent == null){
            throw new UtryException(ExceptionConstant.INTER_SYSTEM_ERROR_CODE,"没有该学生信息！");
        }

        StudentDTO studentDTO = new StudentDTO();

        BeanUtils.copyProperties(tStudent,studentDTO);

        return studentDTO;
    }

    /**
     *
     * 更新学生信息
     *
     * @param studentUpdateBean
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override public Boolean updateStudent(StudentUpdateBean studentUpdateBean) {
        TStudent tStudent = new TStudent();

        BeanUtils.copyProperties(studentUpdateBean,tStudent);

        int updateResult = studentDao.updateByPrimaryKeySelective(tStudent);

        return updateResult > 0;
    }
}
