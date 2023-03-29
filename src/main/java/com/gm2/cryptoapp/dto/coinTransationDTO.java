package com.gm2.cryptoapp.dto;

import java.math.BigDecimal;

public class coinTransationDTO {

    private String name;
    private BigDecimal quantity;

    public coinTransationDTO(String name, BigDecimal quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
