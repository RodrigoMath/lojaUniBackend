package com.lojaUni.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Compra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @OneToMany
    private List<Item> item;
    @Column
    private double total;

    public Compra(List<Item> item){
        this.item=item;
    }

    public Compra() {
    }

    public Compra(List<Item> item, double total) {
        this.item = item;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }



    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
