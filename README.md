# Sistema de Gerenciamento — Hamburgueria

Sistema web para gerenciamento de uma hamburgueria fictícia, desenvolvido como projeto de
portfólio. Permite cadastrar produtos do cardápio, clientes e criar pedidos com cálculo
automático do valor total.

## Funcionalidades

- **Cardápio (Produtos)**: cadastro, listagem e exclusão de produtos, com nome, descrição,
  preço, categoria e disponibilidade.
- **Clientes**: cadastro, listagem e exclusão de clientes, com nome, telefone e endereço.
- **Pedidos**: criação de pedidos vinculando um cliente a múltiplos produtos com quantidades
  variáveis, com cálculo automático do valor total e status do pedido.
- **Navegação**: menu integrado entre as três seções do sistema.

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.1 (Spring Web, Spring Data JPA)
- Thymeleaf (templates HTML no servidor)
- H2 Database (banco de dados em memória/arquivo)
- Maven

## Como executar localmente

1. Clone o repositório: https://github.com/ILG-Dev/hamburgueria-sistema.git
2. Abra o projeto no IntelliJ IDEA (ou outra IDE Java de sua preferência)
3. Execute a classe `HamburgueriaApplication`
4. Acesse `http://localhost:8081/produtos` no navegador

## Estrutura do projeto:

src/main/java/com/ilgdev/hamburgueria/
├── model/ → Entidades (Produto, Cliente, Pedido, ItemPedido, StatusPedido)
├── repository/ → Interfaces de acesso ao banco de dados
├── service/ → Regras de negócio (cálculo de total do pedido)
└── controller/ → Controladores web (rotas e páginas)

src/main/resources/templates/ → Páginas HTML (Thymeleaf)


## Autor

Ivan Lopes Guimarães — [github.com/ILG-Dev](https://github.com/ILG-Dev)
