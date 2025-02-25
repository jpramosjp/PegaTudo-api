package br.com.mercado.mercado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.mercado.mercado.model.UserModel;

public interface UserRepo extends JpaRepository <UserModel, Long> {
    
    Optional<UserModel> findByUser(String user);

    List<UserModel> findByNameContaining(String name);
}
