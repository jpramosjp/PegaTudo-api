package br.com.mercado.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "list_products")
@Data
@Builder
@AllArgsConstructor
public class ProductsListModel {
    public ProductsListModel(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_list", nullable = false)
    private ListModel list;

    @Column(name = "name_product")
    private String name;

    @Column(name = "qty_product")
    private int quantity;

    @Column(name = "purchased")
    private boolean purchased;

    @Column(name = "status")
    private boolean status;

   

}
