package org.example.UserService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.UserService.models.Role;
import org.example.UserService.models.User;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String email;
    private List<Role> roles;
    private Boolean verified;


    public static UserDTO from(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());
        userDTO.setVerified(user.getVerified());

        return userDTO;
    }
}
