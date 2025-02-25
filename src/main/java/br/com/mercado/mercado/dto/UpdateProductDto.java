package br.com.mercado.mercado.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateProductDto {
    
    private long id;
    private String name;
    private int quantity;
    private boolean purchased;
    private boolean status;
}
