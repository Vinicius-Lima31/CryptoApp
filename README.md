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
CREATE TABLE IF NOT EXISTS `crypto_db`.`coin` 
(
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  `DATETIME` TIMESTAMP NULL,
  `PRICE` DECIMAL(20,2) NULL,
  `QUANTITY` DECIMAL(20,10) NULL,
  PRIMARY KEY (`ID`)
)
ENGINE = InnoDB
```

### Com utilização do Jpql como Script para consultas no nosso Banco de Dados.
Utilizei Spring JPA para fazer a consulta nos dados do banco.
