package com.lojaUni.Service;

import com.lojaUni.Model.Compra;
import com.lojaUni.Model.Item;
import com.lojaUni.Repository.CompraRepository;
import com.lojaUni.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CompraService {
    @Autowired
    CompraRepository compraRepo;
    @Autowired
    ItemRepository itemRepo;


    public void adicionaItemNaCompra(List<Item> item, Compra compra) {
        compra.setItem(item);
    }

    public Optional<Compra> buscarCompra(Long id) {
        return compraRepo.findById(id);
    }

    public Compra adicionaItemCompra(Long id) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não encontrado com o ID: " + id));
        if (item != null) {
            List<Item> itens = new ArrayList<>();
            itens.add(item);
            double total = calculaValorCompra(itens);
            Compra compra = new Compra(itens, total);
            compraRepo.save(compra);
        } else {
            // Lide com o caso em que o item não foi encontrado
            throw new IllegalArgumentException("Item não encontrado com o ID: " + id);
        }
        return null;
    }


    public double calculaValorCompra(List<Item> itens) {
        double valorCompra = 0.0;
        for (Item item : itens) {
            valorCompra += item.getValor() * item.getQuantidade();
        }
        return valorCompra;
    }
}
