package com.example.bankflow.repositories;

import com.example.bankflow.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

// O segredo está aqui: "extends JpaRepository<Transaction, Long>"
// Isso dá "poderes" para essa interface salvar, buscar e deletar sem você escrever código.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}