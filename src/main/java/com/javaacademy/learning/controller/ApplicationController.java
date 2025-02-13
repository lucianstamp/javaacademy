package com.javaacademy.learning.controller;

import com.javaacademy.learning.dto.ApplicationCreateDTO;
import com.javaacademy.learning.dto.ApplicationDTO;
import com.javaacademy.learning.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public ApplicationDTO createApplication(@RequestBody ApplicationCreateDTO applicationCreateDTO) {
        return applicationService.createApplication(applicationCreateDTO);
    }
}
