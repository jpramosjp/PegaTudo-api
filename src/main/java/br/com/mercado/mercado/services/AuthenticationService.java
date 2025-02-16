package br.com.mercado.mercado.services;



import br.com.mercado.mercado.dto.LoginUserDto;
import br.com.mercado.mercado.dto.RegisterUserDto;
import br.com.mercado.mercado.exceptions.UserAlreadyExistsException;
import br.com.mercado.mercado.model.UserModel;
import br.com.mercado.mercado.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    public AuthenticationService(
        UserRepo userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel signup(RegisterUserDto input) {
        if (userRepository.findByUser(input.getUser()).isPresent()) {
            throw new UserAlreadyExistsException("Usuário " + input.getUser() + " já existe!");
        }
        UserModel user = UserModel.builder()
        .user(input.getUser())
        .name(input.getName())
        .email(input.getEmail())
        .password(passwordEncoder.encode(input.getPassword()))
        .build();

        return userRepository.save(user);
    }

    public UserModel authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUser(),
                        input.getPassword()
                )
        );

        return userRepository.findByUser(input.getUser())
                .orElseThrow();
    }

    
}