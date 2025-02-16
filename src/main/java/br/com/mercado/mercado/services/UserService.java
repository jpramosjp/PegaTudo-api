package br.com.mercado.mercado.services;

import org.springframework.stereotype.Service;

import br.com.mercado.mercado.model.UserModel;
import br.com.mercado.mercado.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

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
}