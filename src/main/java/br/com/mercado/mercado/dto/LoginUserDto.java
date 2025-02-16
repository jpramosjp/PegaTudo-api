package br.com.mercado.mercado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUserDto {
    private String user;
    
    private String password;
}
