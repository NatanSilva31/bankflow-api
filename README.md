# BankFlow API 💰

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring
Boot](https://img.shields.io/badge/Spring_Boot-3.4-green)
![Status](https://img.shields.io/badge/Status-Completed-blue)

## 📖 Sobre o Projeto

O **BankFlow API** é um sistema de transações financeiras simplificado,
simulando o núcleo de uma carteira digital (Mini-Pix bancário).

O foco do projeto é aplicar regras de negócio robustas com ênfase em
consistência, atomicidade e tratamento de concorrência --- fundamentos
essenciais em aplicações bancárias reais.

## 💼 Regras de Negócio

-   **Cadastro de Usuários**
    -   Clientes Comuns (enviam e recebem dinheiro)
    -   Lojistas (recebem dinheiro, mas não enviam)
-   **Transferências Financeiras**
    -   Validação de saldo antes da transferência
    -   Validação de perfil (Lojistas não podem enviar dinheiro)
    -   Transação atômica com rollback usando `@Transactional`
    -   Bloqueio para valores inválidos ou usuários inexistentes

## 🛠 Tecnologias Utilizadas

-   Java 17
-   Spring Boot 3
-   Spring Data JPA (Hibernate)
-   H2 Database
-   SpringDoc OpenAPI (Swagger UI)
-   Maven

## 🚀 Como Executar

### Pré-requisitos:

-   Java 17 instalado
-   Git instalado

### Passos:

**1️⃣ Clonar o repositório**

``` bash
git clone https://github.com/NatanSilva31/bankflow-api.git
```

**2️⃣ Acessar a pasta do projeto**

``` bash
cd bankflow-api
```

**3️⃣ Rodar o projeto**

``` bash
./mvnw spring-boot:run
```

A API estará acessível em:

    http://localhost:8080

## 📚 Documentação da API (Swagger)

Após rodar o servidor, acesse:

    http://localhost:8080/swagger-ui.html

## 🧪 Endpoints Principais

### 👤 Usuários

**Criar usuário**

``` http
POST /users
```

**Listar usuários**

``` http
GET /users
```

### 💸 Transações

**Realizar transferência**

``` http
POST /transactions
```

#### Exemplo (JSON)

``` json
{
  "value": 100.00,
  "senderId": 1,
  "receiverId": 2
}
```

## 🗂 Estrutura do Projeto (Resumo)

    src/main/java/com.bankflow
    │
    ├── config         → Configurações gerais e DataSeeder
    ├── controllers    → Endpoints REST
    ├── domain         → Entidades JPA
    ├── dtos           → Requisições e respostas
    ├── repositories   → Interfaces JPA
    ├── services       → Regras e validações
    └── infra          → Tratamento de erros

## 👨‍💻 Autor

Desenvolvido por **Natanael Silva**

🔗 LinkedIn: https://www.linkedin.com/in/natanael-silva-a91922204/
