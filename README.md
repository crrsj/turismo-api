✈️ Turismo API
Esta é uma API REST para gerenciamento de venda de passagens rodoviárias, desenvolvida com Java 21 e Spring Boot. A aplicação permite o cadastro, consulta, atualização e exclusão de passagens, garantindo a validação dos dados e a persistência em um banco de dados PostgreSQL.

🚀 Tecnologias Utilizadas
Java 21: Utilizando recursos modernos como Records.

Spring Boot 3.x: Framework base para a construção da API.

Spring Data JPA: Para persistência de dados.

PostgreSQL: Banco de dados relacional.

Docker & Docker Compose: Para containerização da aplicação e do banco.

Bean Validation: Para validação de regras de negócio nos DTOs.

Lombok: Para redução de código boilerplate na Entidade.

OpenAPI (Swagger): Para documentação interativa dos endpoints.

🏗️ Arquitetura e Organização
A aplicação segue uma estrutura de camadas para garantir a separação de responsabilidades:

Controle (Controller): Expõe os endpoints e lida com as requisições HTTP.

Serviço (Service): Contém a lógica de negócio e regras de validação.

Repositório (Repository): Interface de comunicação com o banco de dados.

DTO (Data Transfer Object): Objetos para transferência de dados, utilizando Records para imutabilidade.

Conversor (Mapper): Componente responsável por transformar Entidades em DTOs e vice-versa.

🛠️ Como Executar o Projeto
Pré-requisitos
Docker e Docker Compose instalados.

Passo a Passo
Clone o repositório:

Bash
git clone https://github.com/crrsj/turismo-api.git

Suba os containers (API + Banco de Dados):

Bash
    docker-compose up -d --build
    ```

A API estará disponível em: `http://localhost:8080`

---

## 📖 Documentação da API (Endpoints)

A documentação interativa pode ser acessada via Swagger UI (após iniciar a aplicação) em:
`http://localhost:8080/swagger-ui/index.html#/`

### Principais Endpoints:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/api/passagem` | Registra uma nova passagem. |
| **GET** | `/api/passagem` | Lista todas as passagens cadastradas. |
| **GET** | `/api/passagem/{id}` | Busca os detalhes de uma passagem por ID. |
| **PUT** | `/api/passagem/{id}` | Atualiza os dados de uma passagem existente. |
| **DELETE** | `/api/passagem/{id}` | Remove uma passagem do sistema. |

---

## 🛡️ Validações e Regras

A aplicação valida automaticamente os campos enviados no corpo das requisições:
*   **Campos Obrigatórios**: Nome, telefone, origem, destino, poltrona e datas não podem ser nulos.
*   **Valores**: O campo `valor` deve ser sempre positivo (`@Positive`).
*   **Tipos**: Origem e Destino são limitados aos Enums: `ARACAJU`, `ITABAIANA`, `ESTANCIA`, `PIRAMBU`, `JAPARATUBA`.

### Exemplo de JSON para Cadastro:
```json
{
  "nomeCliente": "João Silva",
  "telefone": "79999999999",
  "origem": "ARACAJU",
  "destino": "PIRAMBU",
  "poltrona": 12,
  "dataPartida": "2026-05-10",
  "horaPartida": "08:30:00",
  "dataVolta": "2026-05-15",
  "valor": 45.50
}
🐳 Docker Config
A aplicação já vem configurada com um docker-compose.yml que provisiona:

Container turismo-db: PostgreSQL 16.

Container turismo-api: Imagem Java 21 compilada via Maven.

As variáveis de ambiente para conexão com o banco são injetadas automaticamente via Docker Compose.

Desenvolvido por Carlos Roberto Ribeiro Santos Junior 🚀

```
<img width="1920" height="1080" alt="turismo" src="https://github.com/user-attachments/assets/1923d297-9573-4779-942d-a616bf0823f1" />
