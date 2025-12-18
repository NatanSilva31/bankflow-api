package com.example.bankflow.services;

import com.example.bankflow.domain.transaction.Transaction;
import com.example.bankflow.domain.user.User;
import com.example.bankflow.dtos.TransactionDTO;
import com.example.bankflow.repositories.TransactionRepository;
import com.example.bankflow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        // Agora usamos .getSenderId() (Método clássico)
        User sender = this.userRepository.findById(transaction.getSenderId())
                .orElseThrow(() -> new Exception("Usuário remetente não encontrado"));

        User receiver = this.userRepository.findById(transaction.getReceiverId())
                .orElseThrow(() -> new Exception("Usuário lojista não encontrado"));

        this.validateTransaction(sender, transaction.getValue());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.getValue());
        if(!isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.getValue());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.getValue()));
        receiver.setBalance(receiver.getBalance().add(transaction.getValue()));

        this.repository.save(newTransaction);
        this.userRepository.save(sender);
        this.userRepository.save(receiver);

        return newTransaction;
    }

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == com.example.bankflow.domain.user.UserType.MERCHANT){
            throw new Exception("Usuário do tipo Lojista não pode enviar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        return true;
    }
}