# Eureka Server Project

Este projeto consiste em um sistema de microserviços onde os serviços se registram em um servidor Eureka e se comunicam entre si para realizar determinadas operações.

## Descrição

Este repositório contém o código-fonte de três microserviços:

1. **Client A Service**: Um serviço que faz uma requisição para o serviço Client B e retorna a soma de um número aleatório gerado localmente com um número aleatório gerado pelo Client B.

2. **Client B Service**: Um serviço que valida a saúde dos serviços Client A e Client C, e retorna a soma de um número aleatório gerado localmente com um número aleatório gerado pelo Client C.

3. **Client C Service**: Um serviço que gera e retorna um número aleatório.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **br.ucsal.eurekaserver.controller.ClientAController**: Controlador REST do serviço Client A que expõe um endpoint para obter a soma de números aleatórios.
- **br.ucsal.eurekaserver.service.ClientBService**: Serviço responsável por interagir com o Client C Service e realizar a soma de números aleatórios.
- **br.ucsal.eurekaserver.controller.ClientCController**: Controlador REST do serviço Client C que expõe um endpoint para gerar um número aleatório.

## Pré-requisitos

Certifique-se de ter instalado o seguinte software antes de executar este projeto:

- Java Development Kit (JDK) 8 ou superior
- Apache Maven
- Um servidor Eureka em execução (não fornecido neste projeto)

## Como Executar

1. Clone este repositório em sua máquina local:

   ```
   git clone <URL_do_repositório>
   ```

2. Navegue até o diretório clonado:

   ```
   cd eurekaserver
   ```

3. Compile o projeto usando o Maven:

   ```
   mvn clean install
   ```

4. Inicie cada um dos microserviços individualmente, seguindo a ordem: Client C Service, Client B Service e finalmente Client A Service.

5. Após iniciar todos os microserviços, você pode acessar o endpoint do Client A Service para obter a soma de números aleatórios:

   ```
   GET http://localhost:8081/soma
   ```

## Observações

Certifique-se de configurar corretamente as URLs dos serviços Client A, Client B e Client C nos métodos `validateClientA()` e `validateClientC()` do `ClientBService`, bem como na chamada do método `getForObject()` no método `clientBSum()` do mesmo serviço, para que os microserviços possam se comunicar corretamente.

Certifique-se também de que o servidor Eureka esteja em execução e devidamente configurado para permitir o registro e a descoberta dos serviços.

Este projeto é apenas um exemplo básico de comunicação entre microserviços usando Spring Boot e Eureka Server, e pode ser estendido e configurado de acordo com os requisitos do projeto real.
