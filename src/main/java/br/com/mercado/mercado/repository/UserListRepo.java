package br.com.mercado.mercado.repository;

import br.com.mercado.mercado.model.UserListModel;
import br.com.mercado.mercado.model.UserModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserListRepo extends JpaRepository<UserListModel, Long> {
    
    boolean existsByUserIdAndListId(Long userId, Long listId);
    
    List<UserListModel> findByListId(Long listId);
    
    @Query("SELECT u FROM UserModel u WHERE u.id NOT IN " +
           "(SELECT ul.user.id FROM UserListModel ul WHERE ul.list.id = :listId)")
    List<UserModel> findUsersNotInList(@Param("listId") Long listId);
    
}