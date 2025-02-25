package br.com.mercado.mercado.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.mercado.dto.AddProductDto;
import br.com.mercado.mercado.dto.ProductListResponse;
import br.com.mercado.mercado.dto.UpdateProductDto;
import br.com.mercado.mercado.model.ProductsListModel;
import br.com.mercado.mercado.services.ProductsListService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductsListService productsListService;

    public ProductController(ProductsListService productsListService) {
        this.productsListService = productsListService;
    }


    @GetMapping("/productsByList")
    public ResponseEntity<List<ProductListResponse>> getProductsByList(@RequestParam long idList, @RequestParam boolean status) {
        return ResponseEntity.ok(productsListService.getProductsByListIdAndStatus(idList, status));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ProductsListModel> addProductInList(@RequestBody AddProductDto addProductDto) {
        ProductsListModel product = productsListService.addProductInList(addProductDto);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/updateProduct")
    public ResponseEntity<ProductsListModel> addProductInList(@RequestBody UpdateProductDto updateProductDto) {
        ProductsListModel product = productsListService.updateProductInList(updateProductDto);
        return ResponseEntity.ok(product);
    }
}
