package br.com.mercado.mercado.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListResponse {
    private Long idList;
    private String nameList;
}
