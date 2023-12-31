package com.school.service;

import com.school.client.StudentClient;
import com.school.entity.School;
import com.school.repository.SchoolRepository;
import com.school.response.FullSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchool() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        var school = schoolRepository
                .findById(schoolId)
                .orElse(School
                        .builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());

        var student = studentClient.getAllStudentWithSchoolId(schoolId); //find all student from student microservice who is in same school
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .studentList(student)
                .build();
    }
}
