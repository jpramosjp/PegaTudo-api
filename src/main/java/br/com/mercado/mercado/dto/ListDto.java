package br.com.mercado.mercado.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListDto {
    private String name;
    
    private LocalDateTime duration;

    private boolean status;
}
