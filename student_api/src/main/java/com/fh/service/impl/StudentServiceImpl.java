package com.fh.service.impl;

import com.fh.dao.StudentDao;
import com.fh.entity.StudentInfo;
import com.fh.service.StudentService;
import com.fh.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public void queryStudentList(PageBean<StudentInfo> page) {
        Long count = studentDao.queryCount();
        page.setRecordsFiltered(count);
        page.setRecordsTotal(count);

        List<StudentInfo> studentList = studentDao.queryStudentList(page);
        page.setData(studentList);

    }

    /**
     * 增加
     * @param studentInfo
     */
    @Override
    public void addStudent(StudentInfo studentInfo) {
        studentInfo.setIsDel(1);
        studentDao.insert(studentInfo);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @Override
    public StudentInfo toUpdateStudent(Integer id) {
        return studentDao.selectById(id);
    }

    /**
     * 修改
     * @param studentInfo
     */
    @Override
    public void updateStudent(StudentInfo studentInfo) {
        studentDao.updateById(studentInfo);
    }
}
