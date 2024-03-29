package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {

    private StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudent() {
        return ResponseEntity.ok(service.findAllStudent());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentWithSchoolId(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(service.findAllStudentWithSchoolId(schoolId));
    }
}
