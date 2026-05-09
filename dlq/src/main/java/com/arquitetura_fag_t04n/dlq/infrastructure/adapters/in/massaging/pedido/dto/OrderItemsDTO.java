package com.arquitetura_fag_t04n.dlq.infrastructure.adapters.in.massaging.pedido.dto;

public class OrderItemsDTO {
    private Integer sku;
    private Integer amount;

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}