package com.school.service;

import com.school.entity.School;
import com.school.repository.SchoolRepository;
import com.school.response.FullSchoolResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolService {

    @Autowired
    private final SchoolRepository schoolRepository;

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

        var student = null; //find all student from student microservice who is in same school
        return null;
    }
}
