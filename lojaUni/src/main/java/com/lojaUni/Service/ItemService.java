package com.lojaUni.Service;

import com.lojaUni.Model.Item;
import com.lojaUni.Model.TipoVela;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private static final List<Item> ITENS_FIXOS = new ArrayList<>();

    static {
        // Inicializa os 3 itens fixos
        ITENS_FIXOS.add(new Item(1, 10.0, TipoVela.CITRA));
        ITENS_FIXOS.add(new Item(1, 15.0, TipoVela.PURORESPIRO));
        ITENS_FIXOS.add(new Item(1, 20.0, TipoVela.AMORE));

    }

    public static List<Item> getItensFixos() {
        return new ArrayList<>(ITENS_FIXOS);
    }

}
