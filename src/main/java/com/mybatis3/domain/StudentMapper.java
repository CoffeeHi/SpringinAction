package com.mybatis3.domain;

import java.util.List;

/**
 * Created by 陈祥 on 2016/9/8.
 */
public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    void insertStudent(Student student);
}
