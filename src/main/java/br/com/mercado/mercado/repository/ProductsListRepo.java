package br.com.mercado.mercado.repository;

import br.com.mercado.mercado.model.ProductsListModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsListRepo extends JpaRepository<ProductsListModel, Long> {
    List<ProductsListModel> findByListIdAndStatus(Long listId, boolean status);
}