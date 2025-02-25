package br.com.mercado.mercado.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupResponse {
    
    private ListResponse list;

    private List<UserResponse> userInList;

    private List<UserResponse> userNotInList;
    
    private List<ProductListResponse> products;

}
