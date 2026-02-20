<h2>🍺 Beerstock API - Desenvolvimento de testes unitários para validar uma API REST de gerenciamento de estoques de cerveja.</h2>

> API RESTful para gerenciamento de estoque de cervejas  
> Desenvolvida com arquitetura moderna baseada em Java 21 e Spring Boot 3

---
## 📌 Projeto Original

Este projeto é baseado no repositório original:  
👉 https://github.com/rpeleias-v1/beer_api_digital_innovation_one

---
## 📌 Sobre o Projeto

O **Beerstock API** é uma aplicação backend construída com foco em:

- Arquitetura limpa e organizada
- Boas práticas REST
- Separação de responsabilidades
- Uso de DTOs e Mappers
- Documentação automática da API
- Código preparado para escalar

O projeto foi modernizado para acompanhar as versões mais recentes do ecossistema Spring.

---

## 🚀 Stack Tecnológica

- ☕ Java 21 (LTS)
- 🌱 Spring Boot 3.4.2
- 🗄 Spring Data JPA
- 🔎 Jakarta Validation
- 🔁 MapStruct
- 🧠 Lombok
- 🗃 H2 Database
- 📊 Spring Actuator
- 📄 Springdoc OpenAPI
- 🧪 JUnit / Spring Boot Test
- 🛠 Maven

---

## 🔄 Processo de Modernização

O projeto foi atualizado de:

- Spring Boot 2.3
- Java 14
- Swagger (Springfox)

Para:

- Spring Boot 3.4.2
- Java 21 (LTS)
- OpenAPI moderno (Springdoc)

### 🔥 Principais Ajustes Técnicos

- Migração `javax.*` → `jakarta.*`
- Atualização do MapStruct para 1.5.5
- Atualização do Lombok
- Modernização do Maven Compiler Plugin
- Substituição do Swagger legado

Essa atualização garante:

- ✔ Compatibilidade com Spring Framework 6  
- ✔ Melhor performance  
- ✔ Maior segurança  
- ✔ Base pronta para produção  

---

## 🛠 Como Executar

### Pré-requisitos

- Java 21
- Maven 3.9+

### Executar aplicação

```bash
mvn clean install
mvn spring-boot:run
```
---

### BeerServiceBusinessRulesTest – Teste acrescentado

**Objetivo:**
Testar as regras de negócio do BeerService relacionadas ao gerenciamento de estoque de cervejas, garantindo que incrementos e decrementos respeitem os limites definidos (max e mínimo 0).

#### Setup

- Um mock do BeerRepository é usado para simular operações de banco.
- Um objeto Beer é criado para os testes (BeerBuilder).
- BeerService é injetado com o mock, permitindo testar a lógica sem depender do banco real.

#### Testes Realizados

1. **Incremento acima do máximo (`shouldThrowException_whenIncrementExceedsMaxStock`)**
   - **Cenário:** adicionar quantidade que ultrapassa o estoque máximo.
   - **Esperado:** lançar **BeerStockExceededException**.
   - **Verificação:** nenhum `save` é chamado no repository.

2. **Decremento abaixo de zero (`shouldThrowException_whenDecrementResultsInNegativeStock`)**
   - **Cenário:** remover mais cerveja do que existe no estoque.
   - **Esperado:** lançar **BeerStockExceededException**.
   - **Verificação:** nenhum `save` é chamado.

3. **Incremento válido (`shouldUpdateQuantity_whenIncrementIsWithinLimit`)**
   - **Cenário:** adicionar quantidade dentro do limite máximo.
   - **Esperado:** estoque atualizado corretamente.
   - **Verificação:** `save` é chamado no repository.

4. **Decremento válido (`shouldUpdateQuantity_whenDecrementIsValid`)**
   - **Cenário:** remover quantidade válida do estoque.
   - **Esperado:** estoque atualizado corretamente.
   - **Verificação:** `save` é chamado no repository.


### 👨‍💻 Autor da atualização

Vitor Jônatas

Backend Developer | QA | Java | Spring Boot





