package br.com.mercado.mercado.services;

import br.com.mercado.mercado.model.UserListModel;
import br.com.mercado.mercado.model.UserModel;
import br.com.mercado.mercado.dto.GroupResponse;
import br.com.mercado.mercado.dto.UserResponse;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.repository.UserListRepo;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserListService {

    private final UserListRepo userListRepo;
    private final UserService userService;
    private final ListService listService;

    public UserListService(UserListRepo userListRepo, UserService userService, ListService listService) {
        this.userListRepo = userListRepo;
        this.userService = userService;
        this.listService = listService;
    }

    public void addUserToList(Long userId, Long listId) {
        UserModel user = userService.getUserModel(userId);
        ListModel list = listService.getListModel(listId);
        if(validateUserInList(userId, listId)) {
            return;
        }

        UserListModel userList = UserListModel.builder()
                .user(user)
                .list(list)
                .build();

        userListRepo.save(userList);
    }

    public boolean validateUserInList(Long userId, Long listId) {
        if (userListRepo.existsByUserIdAndListId(userId, listId)) {
            return true;
        }
        return false;
    }

    public List<UserResponse> getUsersByListId(Long listId) {
        List<UserListModel> userLists = userListRepo.findByListId(listId);
        return userLists.stream()
        .map(userListModel -> {
            var userModel = userListModel.getUser();
            return UserResponse.builder()
                    .id(userModel.getId())
                    .name(userModel.getName())
                    .user(userModel.getUser()) 
                    .build();
        })
        .collect(Collectors.toList());
    }

    public List<UserResponse> getUsersNotInList(Long listId) {
        List<UserModel> usersNotInList = userListRepo.findUsersNotInList(listId);

        return usersNotInList.stream()
                .map(userModel -> UserResponse.builder()
                        .id(userModel.getId())
                        .name(userModel.getName())
                        .user(userModel.getUser())
                        .build())
                .collect(Collectors.toList());
    }

   

    public GroupResponse getGroupInformation(Long listId) {
       
        return GroupResponse.builder()
        .list(listService.getListResponse(listId))
        .userInList(getUsersByListId(listId))
        .userNotInList(getUsersNotInList(listId))
        .build();
    }
}