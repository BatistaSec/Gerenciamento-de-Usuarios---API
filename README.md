# 🚀 API REST de Gerenciamento de Usuários

## 📌 Sobre o projeto
API REST desenvolvida para gerenciamento de usuários, permitindo operações completas de CRUD (Create, Read, Update e Delete), utilizando boas práticas de desenvolvimento backend com Java e Spring Boot.

A aplicação conta com autenticação e autorização utilizando JWT (JSON Web Token), garantindo segurança no acesso às rotas protegidas.

---

## 🧠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- SpringDoc OpenAPI / Swagger UI
- MySQL
- Docker
- Maven

---

## ⚙️ Funcionalidades

- ✅ Cadastro de usuários e geração de Token JWT
- ✅ Listagem de usuários
- ✅ Busca de usuário por ID
- ✅ Atualização de dados
- ✅ Exclusão de usuários
- ✅ Proteção de rotas com Bearer Token
- ✅ Documentação interativa com Swagger

---

## 🔒 Segurança e autenticação

A API utiliza autenticação stateless baseada em JWT. Após o cadastro, um token é gerado e deve ser enviado nas requisições protegidas:
Authorization: Bearer SEU_TOKEN

**Rotas públicas**
POST /usuarios

**Rotas protegidas**
GET    /usuarios

GET    /usuarios/{id}

PUT    /usuarios/{id}

DELETE /usuarios/{id}

---

## 📚 Documentação da API

Após iniciar a aplicação, acesse o Swagger UI:
http://localhost:8080/swagger-ui/index.html

**Como autenticar no Swagger:**

1. Execute `POST /usuarios` com nome, email e senha
2. Copie o token retornado:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
3. Clique em **Authorize** no canto superior direito
4. Informe `Bearer SEU_TOKEN`
5. Agora você pode testar todas as rotas protegidas

---

## 🔒 Validação e tratamento de erros

- Validação com Bean Validation (`@NotBlank`, `@Email`)
- Tratamento global de exceções com `@RestControllerAdvice`
- Retorno padronizado de mensagens de erro

---

## 🛢️ Banco de dados

- MySQL com Spring Data JPA
- Criação automática de tabelas com Hibernate

---

## 🐳 Docker

Para rodar sem precisar instalar MySQL localmente:

```bash
docker-compose up --build
```

A API estará disponível em `http://localhost:8080/swagger-ui/index.html`

Para parar:
```bash
docker-compose down
```

---

## ▶️ Como executar

### Opção 1 — Com Docker (recomendado)

```bash
docker-compose up --build
```

### Opção 2 — Local com Maven

1. Clone o repositório:
```bash
git clone https://github.com/BatistaSec/Gerenciamento-de-Usuarios---API.git
```

2. Crie o banco de dados:
```sql
CREATE DATABASE usuarios_db;
```

3. Configure `src/main/resources/application-dev.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usuarios_db
spring.datasource.username=root
spring.datasource.password=sua_senha
```

4. Execute a aplicação:
```bash
./mvnw spring-boot:run "-Dspring-boot.run.profiles=dev"
```

---

## 🧪 Testes automatizados

- ✅ Testes unitários do Service com Mockito
- ✅ Testes do Controller com MockMvc
- ✅ Testes do JwtService
- ✅ CI com GitHub Actions (testes rodam automaticamente a cada push)

Para rodar os testes localmente:
```bash
./mvnw test
```

---

## 🧪 Testando a API

Você pode testar via Swagger UI, Postman ou Insomnia.

**Exemplo de requisição:**
POST /usuarios
```json
{
  "nome": "João",
  "email": "joao@email.com",
  "senha": "123456"
}
```

**Exemplo de resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## 📂 Estrutura do projeto
src/main/java/com/gerenciamento/

├── controller

├── service

├── repository

├── entity

├── exception

├── JWT

└── Swagger

---

## 🎯 Melhorias futuras

- ☁️ Deploy em Cloud
- 🔑 Refresh Token
- 📊 Monitoramento com Spring Boot Actuator
- 📝 Centralização de logs

---

## 👨‍💻 Autor

**João Batista**  
GitHub: [https://github.com/BatistaSec](https://github.com/BatistaSec)
