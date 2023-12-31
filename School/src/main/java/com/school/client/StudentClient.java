package com.school.client;

import com.school.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.student-url}")
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Student> getAllStudentWithSchoolId(@PathVariable("school-id") Integer schoolId);
}
