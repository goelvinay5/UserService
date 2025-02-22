package org.woolf.UserService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.woolf.UserService.models.Role;
import org.woolf.UserService.models.User;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;
    private Boolean verified;


    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setVerified(user.getVerified());

        return userDto;
    }
}
