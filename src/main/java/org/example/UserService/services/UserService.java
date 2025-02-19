package org.example.UserService.services;

import org.example.UserService.dtos.SignUpRequestDTO;
import org.example.UserService.models.User;
import org.example.UserService.repositories.UserRepository;
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

    public User signUp(SignUpRequestDTO requestDTO) {
        User user = new User();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setHashedPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setVerified(false);

        return repository.save(user);
    }
}
