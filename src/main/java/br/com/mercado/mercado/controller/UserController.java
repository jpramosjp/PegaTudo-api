package br.com.mercado.mercado.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.mercado.dto.UserResponse;
import br.com.mercado.mercado.model.UserModel;
import br.com.mercado.mercado.services.UserService;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserModel> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserModel currentUser = (UserModel) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<UserResponse>> findName(String name) {
        List <UserResponse> users = userService.getUserByName(name);

        return ResponseEntity.ok(users);
    }

    @GetMapping("/userNotInList")
    public List<UserResponse> userNotInList(@RequestParam Long idList) {
        return userService.getUsersNotInList(idList);
    }
}