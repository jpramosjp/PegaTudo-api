package br.com.mercado.mercado.repository;

import br.com.mercado.mercado.model.UserListModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepo extends JpaRepository<UserListModel, Long> {
    boolean existsByUserIdAndListId(Long userId, Long listId);
    List<UserListModel> findByListId(Long listId);
}