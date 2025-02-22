package org.woolf.UserService.services;

import org.woolf.UserService.dtos.SignUpRequestDto;
import org.woolf.UserService.models.User;
import org.woolf.UserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(SignUpRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setHashedPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setVerified(false);

        return repository.save(user);
    }
}
