package br.com.mercado.mercado.services;

import org.springframework.stereotype.Service;

import br.com.mercado.mercado.dto.ListDto;
import br.com.mercado.mercado.dto.ListResponse;
import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.repository.ListRepo;

@Service
public class ListService {
    
    private final ListRepo listRepo;

    public ListService(ListRepo listRepo) {
        this.listRepo = listRepo;
    }

    public ListResponse createList(ListDto listDto) {
        
       ListModel listModel = ListModel.builder()
       .name(listDto.getName())
       .status(listDto.isStatus())
       .duration(listDto.getDuration())
       .build();
      

       return getListResponse(listRepo.save(listModel).getId());
    }

    public ListModel getListModel (Long idList) {
        return listRepo.findById(idList)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));
    }

    public ListResponse getListResponse(Long idList) {
        ListModel listModel = listRepo.findById(idList).orElseThrow(() -> new RuntimeException("Lista não encontrada"));
        return ListResponse.builder().idList(listModel.getId()).nameList(listModel.getName()).build();
    }
}
