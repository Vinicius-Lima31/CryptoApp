package com.gm2.cryptoapp.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

// Usando agora Spring JPA
// Definindo ela como @Enitity
// E fazendo seu mapeamento lá com a tabela coin do nosso Banco de dados com @Table(name = "nome da tabela")
@Entity
@Table(name = "coin")
public class Coin {

    // Definindo seu id
    // Usando @GeneratedValue para ele se autogerenciar, e usando o strategy para ele se autoincrementar
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Usamos @Column para mapear com as colunas que temos no nosso banco de dados

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    @Column(name = "DATETIME")
    private Timestamp dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
