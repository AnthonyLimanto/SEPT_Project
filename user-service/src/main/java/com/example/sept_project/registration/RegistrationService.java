package com.example.sept_project.registration;

import com.example.sept_project.user.AppUser;
import com.example.sept_project.user.AppUserRole;
import com.example.sept_project.user.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        Boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(new AppUser(request.getUsername(), request.getEmail(), request.getPassword(), AppUserRole.PATIENT));
    }
}
