package com.limaTaylor.listaTudo.Controller;

import com.limaTaylor.listaTudo.Dtos.ListDto;
import com.limaTaylor.listaTudo.Models.ListModel;
import com.limaTaylor.listaTudo.Repositories.ListRepository;
import com.limaTaylor.listaTudo.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ListController {
    @Autowired
    ListRepository listRepository;
    @PostMapping("/List")
    public ResponseEntity<ListModel> saveList(@Valid @RequestBody ListDto listDto){
        //Criando uma objeto no banco.
        var listModel = new ListModel();
        listModel.setListId(listDto.getListId());
        listModel.setGroupId(listDto.getGroupId());
        listModel.setNameList(listDto.getNameList());
        listModel.setItemId(listDto.getItemId());
        listModel.setItemQuantity(listDto.getItemQuantity());
        listModel.setItemValue(listDto.getItemValue());
        //Retornando HTTP de criação da lista
        return ResponseEntity.status(HttpStatus.CREATED).body(listRepository.save(listModel));
    }

    @GetMapping("/List/{listId}")
    public ResponseEntity<Object> getOneList(@PathVariable(value = "listId") int listId){
        //Realizando o retorno como objeto a caracter de estudo.
        final Optional<ListModel> optional = listRepository.findById(listId);
        if (optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar está lista");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(optional.get());
        }
    }
    @GetMapping("/List/All")
    public ResponseEntity<List<ListModel>> getAllUsers(){
        //retornando uma lista com a relação de todos os objetos de lista do banco
        return ResponseEntity.ok(listRepository.findAll());
    }

    @DeleteMapping("/List/{listId}")
    public ResponseEntity<ListModel> deleteList(@PathVariable( value = "listId") int listId){
        final Optional<ListModel> optional = listRepository.findById(listId);
        if (optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            listRepository.delete(optional.get());
            return ResponseEntity.ok(optional.get());
        }
    }
}
