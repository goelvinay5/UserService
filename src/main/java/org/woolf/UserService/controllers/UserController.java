package org.woolf.UserService.controllers;

import org.woolf.UserService.dtos.SignUpRequestDto;
import org.woolf.UserService.dtos.UserDto;
import org.woolf.UserService.models.User;
import org.woolf.UserService.services.UserService;
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
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        User user = service.signUp(requestDto);
        return new ResponseEntity<>(
                UserDto.from(user),
                HttpStatus.CREATED
        );
    }
}
