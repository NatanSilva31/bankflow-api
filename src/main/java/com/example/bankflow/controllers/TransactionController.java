package com.example.bankflow.controllers;

import com.example.bankflow.domain.transaction.Transaction;
import com.example.bankflow.dtos.TransactionDTO;
import com.example.bankflow.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation; // Importe isso
import io.swagger.v3.oas.annotations.responses.ApiResponse; // Importe isso
import io.swagger.v3.oas.annotations.tags.Tag; // Importe isso
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transações", description = "Endpoints responsáveis pelas transferências financeiras") // Nome bonito no grupo
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    @Operation(
            summary = "Realizar nova transferência",
            description = "Transfere valores entre um usuário Comum e um Lojista ou outro usuário.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Transação realizada com sucesso"),
                    @ApiResponse(responseCode = "422", description = "Saldo insuficiente ou dados inválidos"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}