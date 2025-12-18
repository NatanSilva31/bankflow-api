package com.example.bankflow.config;

import com.example.bankflow.domain.user.User;
import com.example.bankflow.domain.user.UserType;
import com.example.bankflow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se o banco está vazio antes de criar
        if (userRepository.count() == 0) {

            // --- CRIANDO USUÁRIO 1 (COMUM - VAI PAGAR) ---
            User user1 = new User();
            user1.setFirstName("João");
            user1.setLastName("Silva");
            user1.setDocument("12345678900");
            user1.setEmail("joao@email.com");
            user1.setPassword("123456");
            user1.setBalance(new BigDecimal("1000.00")); // Começa com 1000 reais
            user1.setUserType(UserType.COMMON);

            userRepository.save(user1);

            // --- CRIANDO USUÁRIO 2 (LOJISTA - VAI RECEBER) ---
            User user2 = new User();
            user2.setFirstName("Maria");
            user2.setLastName("Loja");
            user2.setDocument("98765432100");
            user2.setEmail("maria@loja.com");
            user2.setPassword("123456");
            user2.setBalance(new BigDecimal("0.00")); // Começa zerado
            user2.setUserType(UserType.MERCHANT);

            userRepository.save(user2);

            System.out.println("---------------------------------------------");
            System.out.println("BANCO POPULADO COM SUCESSO!");
            System.out.println("Usuário João (ID " + user1.getId() + ") criado.");
            System.out.println("Usuário Maria (ID " + user2.getId() + ") criado.");
            System.out.println("---------------------------------------------");
        }
    }
}