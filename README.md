# CryptoApp

## Aplicação SPRING BOOT CRUD com Banco de dados MySQL

Fiz um pequeno projeto utilizando **SPRING BOOT** realizando um **CRUD** em um banco de dados **MySQL**, onde o usuário consegue estar cadastrando sua criptomoeda.
No momento está sem o front end, em breve  irei estar  aplicando o VueJS na aplicação.


## Dependências utilizadas
* spring-boot-starter
* spring-boot-starter-web
* spring-boot-starter-jdbc
* spring-boot-starter-data-jpa
* mysql-connector-java

## Banco de dados MySQL

``` 
CREATE TABLE coin
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(100),
    DATETIME TIMESTAMP,
    PRICE NUMERIC(20,2),
    QUANTITY NUMERIC(20,10)
); 
```

### Com utilização do Jpql como Script para consultas no nosso Banco de Dados.
