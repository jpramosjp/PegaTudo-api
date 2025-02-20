package br.com.mercado.mercado.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserListDto {
    private ListDto listDto;
    private List<Long> usersIds;
}
