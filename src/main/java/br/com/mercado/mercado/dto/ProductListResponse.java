package br.com.mercado.mercado.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductListResponse {
    private long id;

    private long listId;

    private String name;
    
    private int quantity;

    private boolean purchased;

    private boolean status;

}
