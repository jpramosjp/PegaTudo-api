package br.com.mercado.mercado.services;

import org.springframework.stereotype.Service;

import br.com.mercado.mercado.dto.UserResponse;
import br.com.mercado.mercado.model.UserModel;
import br.com.mercado.mercado.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> allUsers() {
        List<UserModel> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public List<UserResponse> getUserByName(String name) {
        return userRepository.findByNameContaining(name).stream()
            .map(userModel -> {
                UserResponse userResponse = UserResponse.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .user(userModel.getUser())
                .build();
                return userResponse;
            })
            .collect(Collectors.toList());
    }

    public UserModel getUserModel(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
   
}