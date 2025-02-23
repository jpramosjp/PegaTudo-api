package br.com.mercado.mercado.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddUserDto {
    private Long  idList;
    private List<Long> usersIds;
}
