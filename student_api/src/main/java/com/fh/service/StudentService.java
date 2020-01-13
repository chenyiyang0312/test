package com.fh.service;

import com.fh.entity.StudentInfo;
import com.fh.utils.PageBean;

public interface StudentService {
    void queryStudentList(PageBean<StudentInfo> page);

    void addStudent(StudentInfo studentInfo);

    StudentInfo toUpdateStudent(Integer id);

    void updateStudent(StudentInfo studentInfo);
}
