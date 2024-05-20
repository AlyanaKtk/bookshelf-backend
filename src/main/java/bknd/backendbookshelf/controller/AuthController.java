package bknd.backendbookshelf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:3000") //для React
public class AuthController {
    @GetMapping("/auth")
    public Principal user(Principal user) {
        return user;
    }
}
