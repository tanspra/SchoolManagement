package com.school.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "student-service", url = "${application.config.student-url}")
public interface StudentClient {
}
