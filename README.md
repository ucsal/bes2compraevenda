# Plataforma para Compra, Venda e Transporte de Produtos

Este projeto é uma plataforma para a realização de compra, venda e transporte de produtos utilizando Spring Boot.

## Requisitos

Para que o projeto funcione, é necessário ter:

- **Java 21**
- **Maven 4.0.0**

## Tecnologias Utilizadas

- **Spring Boot**
- **Netflix Eureka Client**

## Configurações para o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/ucsal/bes2compraevenda/

2. <p>Inicie o Eureka Server, o API Gateway e os três microserviços normalmente através do botão de rodar o código na sua IDE de preferência.</p>

<br>

**Importante:**

- **A pasta Eureka Client A é o Order Service.**
- **A pasta Eureka Client B é o Payment Service.**
- **A pasta Eureka Client C é o Shipping Dispatch.**

## 

**Criação do pedido**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251012326442930227/d728a811-a2e8-4b35-b33e-2731f3abde1c.png?ex=666d0785&is=666bb605&hm=1f3c058d77eef70448b0e4e6189b41b14d97c78f6cab5b59d020d939213cb23a&)

<br>

**Falha no pagamento com valor incorreto**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251012327009026068/cce2d28d-5f26-4eff-963b-757000988667.png?ex=666d0785&is=666bb605&hm=1a0a2fe31302b17f6aa73cb7a5afb8f2e0be49b1ad9d7036a2b3f8959bc69df8&)

<br>

**Pagamento bem-sucedido com valor correto**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251012327285854338/19cdcafa-791c-44a7-b8ec-8571185b589d.png?ex=666d0785&is=666bb605&hm=06be3ca58574642e183d2816f3f346ec7e6be024f8cc52db1b9ed7b851072ad1&)

<br>

**Recuperando o valor do pedido criado temos agora informado "Pago" no lugar de "Criado"**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251012327512215674/729e1e65-55c9-44fc-a688-59f84fe9a2af.png?ex=666d0785&is=666bb605&hm=64c9dd24c84b5d0dd382a7b0084fa4ea6b876cec56c2650f249f11348b2053ea&)

<br>

**Realização do envio do produto**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251012327789166682/9d6e572d-acce-4a99-b63e-bf9cfc3da14f.png?ex=666d0785&is=666bb605&hm=7729ffcfdfe612e165f5467f3c2f4a398c45c684ab8f71a0ea5104b660665269&)

<br>

**Recuperando o valor do pedido criado e pago temos agora informado "Enviado" no lugar de "Pago"**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251012328040828989/4d45aa93-104f-4ae0-b2c3-bc5e583ccad4.png?ex=666d0785&is=666bb605&hm=9b22c584d43acb25d9c214111c1ede62188a47c579e58cde09201ce1cd2db253&)

<br>

**Em caso de informação incorreta, o pedido não estará disponível para envio**

![image](https://cdn.discordapp.com/attachments/987696312269025313/1251013062320984084/44b868cc-c38e-4495-b163-ff53b86a13f8.png?ex=666d0834&is=666bb6b4&hm=35a04ff1bab9f1d64a06edcc4f04f0bcadab3f09dc5113d5615915fe467578b4&)



