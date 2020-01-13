package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.StudentInfo;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentDao extends BaseMapper<StudentInfo> {
    Long queryCount();

    List<StudentInfo> queryStudentList(PageBean<StudentInfo> page);
}
