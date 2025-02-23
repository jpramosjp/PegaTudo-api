package br.com.mercado.mercado.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.mercado.dto.AddUserDto;
import br.com.mercado.mercado.dto.ListResponse;
import br.com.mercado.mercado.dto.UserListDto;
import br.com.mercado.mercado.dto.UserResponse;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.services.ListService;
import br.com.mercado.mercado.services.UserListService;
import org.springframework.web.bind.annotation.RequestParam;




@RequestMapping("/group")
@RestController
public class GroupController {
    
    private final ListService listService;
    private final UserListService userListService;

    public GroupController(ListService listService, UserListService userListService) {
       this.listService = listService;
       this.userListService = userListService;
    }

    @PostMapping("/create")
    public ResponseEntity<ListResponse> createList(@RequestBody UserListDto userListDto) {
        ListModel listModel = listService.createList(userListDto.getListDto());
        userListDto.getUsersIds().stream().forEach(userId -> userListService.addUserToList(userId, listModel.getId()));

        return ResponseEntity.ok(ListResponse.builder().idList(listModel.getId()).build());
        
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody AddUserDto addUserDto) {
        addUserDto.getUsersIds().stream().forEach(userId -> userListService.addUserToList(userId, addUserDto.getIdList()));

        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/usersInList")
    public List<UserResponse> userInList(@RequestParam Long idList) {
        return userListService.getUsersByListId(idList);
    }
    
    
    
}
