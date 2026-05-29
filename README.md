# 🚀 API REST de Gerenciamento de Usuários
## 📌 Sobre o projeto
API REST desenvolvida para gerenciamento de usuários, permitindo operações completas de CRUD (Create, Read, Update e Delete), com foco em boas práticas de desenvolvimento backend utilizando Java e Spring Boot.

---

## 🧠 Tecnologias utilizadas
* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## ⚙️ Funcionalidades
✅ Cadastro de usuários
✅ Listagem de usuários
✅ Busca por ID
✅ Atualização de dados
✅ Remoção de usuários

---

## 🔒 Validação e tratamento de erros
* Validação de campos com Bean Validation (@NotBlank, @Email)
* Tratamento global de exceções com @RestControllerAdvice
* Retorno de mensagens de erro padronizadas

---

## 🛢️ Banco de dados
* Integração com MySQL
* Criação automática de tabelas com Hibernate

---

## 📂 Estrutura do projeto
    src/main/java/com/seuprojeto/ 
    ├── controller 
    ├── service 
    ├── repository 
    ├── entity 
    ├── exception

---

## ▶️ Como executar o projeto
### 1. Clonar repositório
##### BASH
     git clone https://github.com/BatistaSec/Gerenciamento-de-Usuarios---API

### 2. Configurar banco de dados
#### Criar o banco no MySQL:
##### SQL
     CREATE DATABASE usuarios_db; 

---

### 3. Configurar application.properties
##### properties 
     spring.datasource.url=jdbc:mysql://localhost:3306/usuarios_db 
     spring.datasource.username=root 
     spring.datasource.password=senha 

     spring.jpa.hibernate.ddl-auto=update s
     pring.jpa.show-sql=true 

---

### 4. Rodar aplicação
#### Pelo IntelliJ ou:

##### BASH
     ./mvnw spring-boot:run 

---

## 🧪 Testes da API
### Você pode testar usando:

* Postman
* Insomnia

### Exemplo de criação de usuário (POST)
    POST /usuarios
#### JSON
    {   "nome": "João",   "email": "joao@email.com",   "senha": "123456" } 

---
## 🎯 Melhorias futuras
* 🔐 Autenticação com JWT
* 📄 Documentação com Swagger
* 🐳 Docker
* ☁️ Deploy em cloud

---

## 👨‍💻 Autor
João - GitHub: https://github.com/BatistaSec
