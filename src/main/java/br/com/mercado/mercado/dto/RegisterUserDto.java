package br.com.mercado.mercado.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RegisterUserDto {
    private String email;

    private String user;
    
    private String password;
    
    private String name;
    
}