package br.com.mercado.mercado.repository;

import br.com.mercado.mercado.model.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepo extends JpaRepository<ListModel, Long> {
}