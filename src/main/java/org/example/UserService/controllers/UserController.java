package org.example.UserService.controllers;

import org.example.UserService.dtos.SignUpRequestDTO;
import org.example.UserService.dtos.UserDTO;
import org.example.UserService.models.User;
import org.example.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }
    @GetMapping("/sign-up")
    public String signUpDemo() {
        return "Development still under progress!";
    }
    @GetMapping("/demo")
    public String demo() {
        return "This is Demo, but Development still under progress!";
    }
    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpRequestDTO requestDTO) {
        User user = service.signUp(requestDTO);
        return new ResponseEntity<>(
                UserDTO.from(user),
                HttpStatus.CREATED
        );
    }
}
