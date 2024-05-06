package com.lojaUni.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public  class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private long quantidade;
    private double valor;
    private TipoVela produto;

    public Item() {
    }

    public Item(long quantidade, double valor, TipoVela produto) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.produto = produto;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVela getProduto() {
        return produto;
    }

    public void setProduto(TipoVela produto) {
        this.produto = produto;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
