package com.utry.mapper;

import com.utry.model.TStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * 学生信息数据层接口
 *
 * @author yangchenglong
 */
@Mapper
public interface TStudentDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    TStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}