package com.javaacademy.learning.service;

import com.javaacademy.learning.dto.ApplicationCreateDTO;
import com.javaacademy.learning.dto.ApplicationDTO;
import com.javaacademy.learning.entities.Application;
import com.javaacademy.learning.dto.ApplicationMapper;
import com.javaacademy.learning.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public ApplicationDTO createApplication(ApplicationCreateDTO applicationCreateDTO) {
        Application application = ApplicationMapper.applicationDTO2Application(applicationCreateDTO.getApplication());
        application = applicationRepository.save(application);
        return ApplicationMapper.application2ApplicationDTO(application);
    }
}
