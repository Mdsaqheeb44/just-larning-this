package com.api.service;

import com.api.RegistrationDto;
import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    public List<RegistrationDto> getRegistration() {
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos = registrations.stream().map(r -> mapToDto(r)).collect(Collectors.toList());

        return dtos;

    }
    RegistrationDto mapToDto(Registration registration){
        RegistrationDto dto = new RegistrationDto();
        dto.setName(registration.getName());
        dto.setEmail(registration.getEmail());
        dto.setMobile(registration.getMobile());
        return dto;


    }


    public RegistrationDto getRegistrationId(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record not found")
        );
       return mapToDto(registration);
    }
}
