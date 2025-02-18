package br.com.mercado.mercado.services;

import br.com.mercado.mercado.model.UserListModel;
import br.com.mercado.mercado.model.UserModel;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.repository.UserRepo;
import br.com.mercado.mercado.repository.ListRepo;
import br.com.mercado.mercado.repository.UserListRepo;

import org.springframework.stereotype.Service;

@Service
public class UserListService {

    private final UserListRepo userListRepository;
    private final UserRepo userRepository;
    private final ListRepo listRepository;

    public UserListService(UserListRepo userListRepository, UserRepo userRepository, ListRepo listRepository) {
        this.userListRepository = userListRepository;
        this.userRepository = userRepository;
        this.listRepository = listRepository;
    }

    public void addUserToList(Long userId, Long listId) {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        ListModel list = listRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        UserListModel userList = UserListModel.builder()
                .user(user)
                .list(list)
                .build();

        userListRepository.save(userList);
    }

}