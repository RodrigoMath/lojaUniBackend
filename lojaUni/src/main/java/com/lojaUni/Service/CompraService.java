package com.lojaUni.Service;

import com.lojaUni.Model.Compra;
import com.lojaUni.Model.Item;
import com.lojaUni.Model.TipoVela;
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

    public Compra adicionaItemCompra(List<Integer> quantidades) {
        //Item item = itemRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não encontrado com o ID: " + id));
        List<Item> items = new ArrayList<>();
        if(!quantidades.isEmpty()){
            if(quantidades.get(0) != 0){
                Item item1= new Item(quantidades.get(0), 10, TipoVela.PURORESPIRO);

                items.add(itemRepo.save(item1));
            }
            if(quantidades.get(1) != 0){
                Item item2= new Item(quantidades.get(1),15, TipoVela.AMORE);
                items.add(itemRepo.save(item2));

            }
            if(quantidades.get(2) != 0){
                Item item3= new Item(quantidades.get(2),20, TipoVela.CITRA);
                items.add(itemRepo.save(item3));

            }
        }
        Compra compra = new Compra();
        if (items != null && !items.isEmpty()) {
            double total = calculaValorCompra(items);
            compra.setItem(items);
            compra.setTotal(total);
            compraRepo.save(compra);
        } else {
            // Lide com o caso em que o item não foi encontrado
            throw new IllegalArgumentException("Problema na compra");
        }
        return compra;
    }


    public double calculaValorCompra(List<Item> itens) {
        double valorCompra = 0.0;
        for (Item item : itens) {
            valorCompra += item.getValor() * item.getQuantidade();
        }
        return valorCompra;
    }
}
