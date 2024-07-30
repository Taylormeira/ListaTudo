package com.limaTaylor.listaTudo.Controller;

import com.limaTaylor.listaTudo.Dtos.UserDto;
import com.limaTaylor.listaTudo.Models.UserModel;
import com.limaTaylor.listaTudo.Repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/User")
    public ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserDto userDto) {
        //Copiando o corpo do json e criando a nova linha de dados na tabela
        var userModel = new UserModel();
        userModel.setUserId(userDto.getUserId());
        userModel.setGroupId(userDto.getGroupId());
        userModel.setFamilyId(userDto.getFamilyId());
        userModel.setUserName(userDto.getUserName());
        userModel.setFullName(userDto.getFullName());
        // Retornando via resposta Http o status da criação do usuário
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @GetMapping("/User/{userId}")
    public ResponseEntity<UserModel> getOneUser(@PathVariable(value = "userId") int userId) {
        //Retornando a lista utilizando a Dto inserindo e buscando dados
//        try {
//            var userDto = new UserDto();
//            var userModel = userRepository.getReferenceById(userId);
//
//            userDto.setUserId(userModel.getUserId());
//            userDto.setFamilyId(userModel.getFamilyId());
//            userDto.setGroupId(userModel.getGroupId());
//            userDto.setUserName(userModel.getUserName());
//            userDto.setFullName(userModel.getFullName());
//
//            return ResponseEntity.ok(userDto);
//
//        } catch (EntityNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }

        final Optional<UserModel> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/User/all")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
