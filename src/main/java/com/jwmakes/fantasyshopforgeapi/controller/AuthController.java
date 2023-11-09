package com.jwmakes.fantasyshopforgeapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @GetMapping(value="/ping", produces = "application/json")
    public String ping() {
        return "{\"data\":\"pong\"}";
    }

}
