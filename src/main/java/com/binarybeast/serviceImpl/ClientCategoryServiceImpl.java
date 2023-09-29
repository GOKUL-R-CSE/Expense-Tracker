package com.binarybeast.serviceImpl;

import com.binarybeast.entity.Category;
import com.binarybeast.entity.Clients;

import com.binarybeast.repository.CategoryRepository;
import com.binarybeast.repository.ClientRepository;
import com.binarybeast.service.ClientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCategoryServiceImpl implements ClientCategoryService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addClientCategory() {
        List<Clients> clients = clientRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        for(Category cat: categories){
            for(Clients cli: clients){
                if(cat.getUserName().equalsIgnoreCase(cli.getUserName())){
                    cat.getClients().add(cli);
                }
            }
        }
        for(Category cat: categories)
            categoryRepository.save(cat);
    }
}
