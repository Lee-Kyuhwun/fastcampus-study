package com.fastcampus.crash.controller;

import com.fastcampus.crash.model.entity.RegistrationPostRequestBody;
import com.fastcampus.crash.model.entity.UserEntity;
import com.fastcampus.crash.model.registration.Registration;
import com.fastcampus.crash.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registrations")
public class RegistrationController {

    @Autowired private RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> getRegistration(Authentication authentication) {
        var registrations = registrationService.getRegistrationsByCurrentUser((UserEntity)authentication.getPrincipal());
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<Registration> getRegsitrationById(@PathVariable Long registrationId
    , Authentication authentication) {
        var registrations = registrationService.getRegistrationsByIdBuCurrentUser(registrationId,(UserEntity)authentication.getPrincipal());
        return ResponseEntity.ok(registrations);
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(
            @Valid @RequestBody RegistrationPostRequestBody registrationPostRequestBody,
            Authentication authentication) {
        var registration = registrationService.createReigstrationByCurrentUser(registrationPostRequestBody
        ,(UserEntity)authentication.getPrincipal());
        return ResponseEntity.ok(registration);
    }


    @DeleteMapping("/{registrationId}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long registrationId,
                                                   Authentication authentication) {
        registrationService.deleteRegistrationByRegistrationIdAndCurrentUser(registrationId
        ,(UserEntity)authentication.getPrincipal());
        return ResponseEntity.noContent().build();
    }
}

