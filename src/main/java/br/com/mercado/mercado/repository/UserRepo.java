package br.com.mercado.mercado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.mercado.mercado.model.UserModel;

public interface UserRepo extends JpaRepository <UserModel, Long> {
    Optional<UserModel> findByUser(String user);

    List<UserModel> findByNameContaining(String name);

    @Query("SELECT u FROM UserModel u WHERE u.id NOT IN " +
           "(SELECT ul.user.id FROM UserListModel ul WHERE ul.list.id = :listId)")
    List<UserModel> findUsersNotInList(@Param("listId") Long listId);
}
