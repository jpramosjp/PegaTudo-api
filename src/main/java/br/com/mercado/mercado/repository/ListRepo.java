package br.com.mercado.mercado.repository;

import br.com.mercado.mercado.model.ListModel;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepo extends JpaRepository<ListModel, Long> {
    Optional<ListModel> findByIdAndDurationAndStatus(Long id, LocalDateTime duration, boolean status);
}