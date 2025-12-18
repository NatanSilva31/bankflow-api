package com.example.bankflow.controllers;

import com.example.bankflow.domain.user.User;
import com.example.bankflow.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bankflow.dtos.UserDTO; // Importe o DTO
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Gerenciamento de usuários e saldos")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Operation(summary = "Criar Usuário", description = "Cria um novo cliente ou lojista")
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = new User(user);
        this.userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos", description = "Mostra todos os usuários e seus saldos atuais")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}