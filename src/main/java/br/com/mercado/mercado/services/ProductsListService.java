package br.com.mercado.mercado.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.mercado.mercado.dto.AddProductDto;
import br.com.mercado.mercado.dto.ProductListResponse;
import br.com.mercado.mercado.dto.UpdateProductDto;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.model.ProductsListModel;
import br.com.mercado.mercado.repository.ProductsListRepo;



@Service
public class ProductsListService {
    
    private final ProductsListRepo productsListRepo;
    private final ListService listService;

    public ProductsListService(ProductsListRepo productsListRepo, ListService listService) {
        this.productsListRepo = productsListRepo;
        this.listService = listService;
    }


    public List<ProductListResponse> getProductsByListIdAndStatus(Long listId, boolean status) {
        List<ProductsListModel> productsListModel = productsListRepo.findByListIdAndStatus(listId, status);
        
        return productsListModel.stream()
                .map(productsListModels -> {
                    var productModel = productsListModels;
                    return ProductListResponse.builder()
                            .id(productModel.getId())
                            .listId(productModel.getList().getId())
                            .name(productModel.getName())
                            .status(productModel.isStatus())
                            .purchased(productModel.isPurchased())
                            .build();
                })
                .collect(Collectors.toList());
    }
    
    


    public ProductsListModel addProductInList(AddProductDto addProductDto) {
        ListModel list = listService.getListModel(addProductDto.getIdList());
        
        ProductsListModel productsListModel = ProductsListModel.builder()
        .list(list)
        .name(addProductDto.getName())
        .quantity(addProductDto.getQuantity())
        .status(addProductDto.isStatus())
        .purchased(addProductDto.isPurchased())
        .build();

        return productsListRepo.save(productsListModel);

    }


    public ProductsListModel updateProductInList(UpdateProductDto updateProductDto) {
        ProductsListModel existingProduct = productsListRepo.findById(updateProductDto.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + updateProductDto.getId()));

        existingProduct.setName(updateProductDto.getName());
        existingProduct.setQuantity(updateProductDto.getQuantity());
        existingProduct.setStatus(updateProductDto.isStatus());
        existingProduct.setPurchased(updateProductDto.isPurchased());

        return productsListRepo.save(existingProduct);
    }
}
