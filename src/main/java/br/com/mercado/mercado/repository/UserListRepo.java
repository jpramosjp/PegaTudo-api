package br.com.mercado.mercado.repository;

import br.com.mercado.mercado.model.UserListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepo extends JpaRepository<UserListModel, Long> {
}