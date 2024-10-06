package com.api.controller;

import com.api.RegistrationDto;
import com.api.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping
    public ResponseEntity<List <RegistrationDto>> getAllRegistration(){

        List<RegistrationDto> registrationDto = registrationService.getRegistration();
        return  new ResponseEntity<>(registrationDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(
            @PathVariable long id
    ){
        RegistrationDto dto = registrationService.getRegistrationId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

}
