# README

## Descrição da Aplicação

Este é um projeto em Java utilizando Spring Boot que realiza a integração com o AWS Simple Queue Service (SQS). O objetivo da aplicação é permitir o envio e recebimento de mensagens através de filas SQS. A aplicação implementa um consumer que processa mensagens recebidas e possui um endpoint para enviar mensagens à fila.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Cloud AWS
- Maven

## Pré-requisitos

Antes de começar, verifique se você possui os seguintes itens instalados na sua máquina:

- Java 21 ou superior
- Maven
- Uma conta AWS com permissões para SQS ou LocalStack configurado para realizar integração

## Configuração do Ambiente

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/lluuccaassfm/spring-aws-sqs.git
   cd spring-aws-sqs
   ```

2. **Configuração da AWS**:
    
    - Crie uma fila no AWS SQS e anote o URL da fila.
    - Configure o método sqsAsyncClient() em SqsConfig.java com a URL e região AWS


## Como Executar

1. **Construir o projeto**:

   ```bash
   mvn clean package
   ```

2. **Executar a aplicação**:

   ```bash
   mvn spring-boot:run
   ```

   A aplicação estará rodando no `http://localhost:8080`.

## Endpoint

### POST /send-message

Esse endpoint permite que você envie uma mensagem para a fila SQS.

**Requisição**

- **URL**: `http://localhost:8080/sqs/send-message`
- **Método**: POST
- **Headers**:
    - Content-Type: application/json
- **Corpo da Requisição**:

```json
{
  "content": "Sua mensagem aqui"
}
```

**Exemplo de cURL**:

```bash
curl -X POST http://localhost:8080/sqs/send-message -H "Content-Type: application/json" -d '{"content":"Olá, SQS!"}'
```

## Consumer

A aplicação também contém um consumer que escuta continuamente a fila SQS e processa as mensagens recebidas. As mensagens são processadas em segundo plano, permitindo que a aplicação permaneça responsiva.


## Contribuição

Sinta-se à vontade para contribuir! Faça um fork do repositório, faça suas alterações e envie um pull request.
