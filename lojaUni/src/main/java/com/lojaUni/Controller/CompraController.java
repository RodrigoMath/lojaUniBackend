package com.lojaUni.Controller;


import com.lojaUni.Model.Compra;
import com.lojaUni.Model.Item;
import com.lojaUni.Service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CompraController {
    private CompraService compraService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Compra>> buscarCompra(@PathVariable Long id) {
        Optional<Compra> compra = compraService.buscarCompra(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Compra> adicionarNaCompra(@RequestParam Long id) {
        try {
            Compra compra = compraService.adicionaItemCompra(id);
            return ResponseEntity.ok(compra);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
