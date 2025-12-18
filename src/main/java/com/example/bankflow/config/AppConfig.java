package com.example.bankflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Fala para o Spring: "Ei, aqui tem configurações do sistema"
public class AppConfig {

    @Bean // Fala para o Spring: "Gerencie esse objeto para mim e injete onde for preciso"
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}