package com.tka.service;

import com.tka.dao.StudentDao;
import com.tka.entity.Student;
import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() {
        studentDao = new StudentDao();
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    public boolean deleteStudent(int rollNo) {
        return studentDao.deleteStudent(rollNo);
    }
}
