# 🚀 API REST de Gerenciamento de Usuários

## 📌 Sobre o projeto

API REST desenvolvida para gerenciamento de usuários, permitindo operações completas de CRUD (Create, Read, Update e Delete), utilizando boas práticas de desenvolvimento backend com Java e Spring Boot.

A aplicação conta com autenticação e autorização utilizando JWT (JSON Web Token), garantindo segurança no acesso às rotas protegidas.

---

## 🧠 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* SpringDoc OpenAPI
* Swagger UI
* MySQL
* Maven

---

## ⚙️ Funcionalidades

* ✅ Cadastro de usuários
* ✅ Geração de Token JWT
* ✅ Listagem de usuários
* ✅ Busca de usuário por ID
* ✅ Atualização de dados
* ✅ Exclusão de usuários
* ✅ Proteção de rotas com Bearer Token
* ✅ Documentação interativa com Swagger

---

## 🔒 Segurança e autenticação

A API utiliza autenticação stateless baseada em JWT (JSON Web Token).

Após realizar o cadastro/login, um token é gerado e deve ser enviado nas requisições protegidas através do header:

```http
Authorization: Bearer SEU_TOKEN
```

### Rotas públicas

```http
POST /usuarios
```

### Rotas protegidas

```http
GET /usuarios
GET /usuarios/{id}
PUT /usuarios/{id}
DELETE /usuarios/{id}
```

---

## 📚 Documentação da API

A documentação está disponível através do Swagger UI.

Após iniciar a aplicação, acesse:

```http
http://localhost:8080/swagger-ui/index.html
```

### Como utilizar a autenticação no Swagger

1. Execute a rota pública:

```http
POST /usuarios
```

2. Copie o token JWT retornado.

Exemplo:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

3. Clique no botão **Authorize** disponível no canto superior direito da documentação.

4. Informe o token JWT.

Exemplo:

```text
Bearer eyJhbGciOiJIUzI1NiJ9...
```

5. Agora você poderá testar todas as rotas protegidas diretamente pelo Swagger.

---

## 🔒 Validação e tratamento de erros

* Validação de campos utilizando Bean Validation

  * `@NotBlank`
  * `@Email`
* Tratamento global de exceções com `@RestControllerAdvice`
* Retorno padronizado de mensagens de erro

---

## 🛢️ Banco de dados

* Integração com MySQL
* Persistência utilizando Spring Data JPA
* Criação automática de tabelas com Hibernate

---

## 📂 Estrutura do projeto

```text
src/main/java/com/gerenciamento/
├── controller
├── service
├── repository
├── model
├── dto
├── exception
├── JWT
└── config
```

---

## ▶️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/BatistaSec/Gerenciamento-de-Usuarios---API.git
```

### 2. Criar o banco de dados

```sql
CREATE DATABASE usuarios_db;
```

### 3. Configurar o application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usuarios_db
spring.datasource.username=root
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Executar a aplicação

Pelo IntelliJ IDEA ou via terminal:

```bash
./mvnw spring-boot:run
```

### 5. Rodar os testes
    ./mvnw test

---

## 🧪 Testando a API

Você pode testar a API utilizando:

* Swagger UI
* Postman
* Insomnia

### Exemplo de requisição

```http
POST /usuarios
```

```json
{
  "nome": "João",
  "email": "joao@email.com",
  "senha": "123456"
}
```

### Exemplo de resposta

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
--- 
### 🧪 Testes automatizados

* ✅ Testes unitários do Service com Mockito
* ✅ Testes do Controller com MockMvc
* ✅ Testes do JwtService
* ✅ CI com GitHub Actions (testes rodam a cada push)

---

## 🎯 Melhorias futuras

* 🐳 Docker
* ☁️ Deploy em Cloud
* 🔑 Refresh Token
* 📊 Monitoramento com Spring Boot Actuator
* 📝 Centralização de logs

---

## 👨‍💻 Autor

João Batista

GitHub:
https://github.com/BatistaSec
