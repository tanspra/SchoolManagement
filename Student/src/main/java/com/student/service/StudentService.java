package com.student.service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentWithSchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
