package br.com.mercado.mercado.services;

import org.springframework.stereotype.Service;

import br.com.mercado.mercado.dto.ListDto;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.repository.ListRepo;

@Service
public class ListService {
    
    private final ListRepo listRepo;

    public ListService(ListRepo listRepo) {
        this.listRepo = listRepo;
    }

    public ListModel createList(ListDto listDto) {
        
       ListModel listModel = ListModel.builder()
       .name(listDto.getName())
       .status(listDto.isStatus())
       .duration(listDto.getDuration())
       .build();

        return listRepo.save(listModel);
    }
}
