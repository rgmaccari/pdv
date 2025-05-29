package com.example.pdv.controller;

import com.example.pdv.domain.Venda;
import com.example.pdv.dto.VendaDTO;
import com.example.pdv.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody @Valid VendaDTO dto, UriComponentsBuilder builder){
        Venda venda = service.insert(dto);

        URI uri = builder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @PutMapping("{id}")
    public ResponseEntity<Venda> update(@RequestParam Integer id, VendaDTO dto){
        Venda venda = new Venda(id, dto);
        venda = service.update(venda);
        return ResponseEntity.ok(venda);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> listaVendas = service.findAll();
        return ResponseEntity.ok(listaVendas);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@RequestParam Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
