package com.school.response;

import com.school.entity.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FullSchoolResponse {
    List<Student> studentList;
    private String name;
    private String email;
}
