package ru.netology.springbootrest.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootrest.config.UserResolve;
import ru.netology.springbootrest.model.Authorities;
import ru.netology.springbootrest.model.User;
import ru.netology.springbootrest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }

    @GetMapping("/authorize-alt")
    public List<Authorities> getAuthoritiesAlt(@UserResolve User user) {
        return service.getAuthorities(user);
    }
}
