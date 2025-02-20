package br.com.mercado.mercado.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.mercado.dto.ListResponse;
import br.com.mercado.mercado.dto.UserListDto;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.services.ListService;
import br.com.mercado.mercado.services.UserListService;



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
}
