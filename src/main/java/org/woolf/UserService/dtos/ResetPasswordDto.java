package org.woolf.UserService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordDto {
    private String email;
    private String resetPasswordQuestion;
    private String resetPasswordAnswer;
    private String newPassword;
}
