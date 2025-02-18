package br.com.mercado.mercado.services;

import org.springframework.stereotype.Service;

import br.com.mercado.mercado.model.ListModel;
import br.com.mercado.mercado.repository.ListRepo;

@Service
public class ListService {
    
    private final ListRepo listRepo;
    private final UserListService userListService;

    public ListService(ListRepo listRepo, UserListService userListService) {
        this.listRepo = listRepo;
        this.userListService = userListService; 
    }

    public ListModel createList() {
        return new ListModel();
    }
}
