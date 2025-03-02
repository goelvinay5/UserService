package org.woolf.UserService.dtos;

import org.woolf.UserService.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String token;

    public static LoginResponseDto fromToken(Token token) {
        LoginResponseDto ldto = new LoginResponseDto();
        ldto.setToken(token.getTokenValue());
        return ldto;
    }
}
