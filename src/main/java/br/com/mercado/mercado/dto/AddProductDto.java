package br.com.mercado.mercado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddProductDto {
    private Long  idList;
    private String name;
    private int quantity;
    private boolean purchased;
    private boolean status;
}
