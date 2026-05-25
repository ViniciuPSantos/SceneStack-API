# 🎬 SceneStack API

REST API desenvolvida com **Java + Spring Boot** que consome dados da **OMDb API** para busca e consulta de filmes e séries.

O projeto permite buscar filmes e séries por título, listar resultados paginados, consultar por IMDb ID e realizar buscas genéricas por tipo de mídia.

---

## 🚀 Funcionalidades

✅ Buscar filme por título  
✅ Buscar série por título  
✅ Listar filmes por nome (paginação)  
✅ Listar séries por nome (paginação)  
✅ Buscar por IMDb ID  
✅ Busca genérica por tipo (`movie` ou `series`)  
✅ Cache com Spring Cache  
✅ Validação de parâmetros (`@Valid`, `@NotBlank`, `@Min`)  
✅ Tratamento global de exceções  
✅ Timeout e Retry para chamadas externas  
✅ Documentação com Swagger/OpenAPI  

---

## 🛠 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring WebFlux (WebClient)
- Spring Validation
- Spring Cache
- Maven
- Swagger / OpenAPI
- OMDb API

---

## 📂 Estrutura do projeto

```text
src/
 ├── client/        # comunicação com OMDb
 ├── config/        # configurações (WebClient, Cache)
 ├── controller/    # endpoints REST
 ├── dto/           # objetos de transferência de dados
 ├── exception/     # tratamento global de erros
 ├── service/       # regras de negócio
```

---

## 📌 Endpoints

### 🎥 Filmes

Buscar filme por título:

```http
GET /api/scenestack/search/movie?title=interstellar
```

Listar filmes:

```http
GET /api/scenestack/movies?title=batman&page=1
```

---

### 📺 Séries

Buscar série por título:

```http
GET /api/scenestack/search/serie?title=dark
```

Listar séries:

```http
GET /api/scenestack/series?title=breaking&page=1
```

---

### 🆔 Busca por IMDb ID

```http
GET /api/scenestack/movie/id/tt0816692
```

---

### 🔎 Busca genérica

Buscar lista:

```http
GET /api/scenestack/search?title=batman&type=movie&page=1
```

Buscar detalhes:

```http
GET /api/scenestack/details?title=dark&type=series
```

---

## ⚙️ Como rodar localmente

### 1. Clone o projeto

```bash
git clone https://github.com/ViniciuPSantos/SceneStack-API.git
```

---

### 2. Entre na pasta do projeto

```bash
cd SceneStack-API
```

---

### 3. Configure sua chave da OMDb API

No arquivo `application.properties`, adicione:

```properties
omdb.api.key=SUA_CHAVE_AQUI
omdb.api.url=https://www.omdbapi.com
```

Você pode obter uma chave gratuita em:

https://www.omdbapi.com/apikey.aspx

---

### 4. Rode a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

---

## 📚 Documentação Swagger

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

---


## 👨‍💻 Autor

**Vinícius de Paula Santos**

GitHub:  
https://github.com/ViniciuPSantos
