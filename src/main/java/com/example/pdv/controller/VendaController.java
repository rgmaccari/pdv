package com.example.pdv.controller;

import com.example.pdv.domain.Venda;
import com.example.pdv.dto.InsertVendaDTO;
import com.example.pdv.dto.UpdateVendaDTO;
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
    public ResponseEntity<Venda> insert(@RequestBody @Valid InsertVendaDTO dto, UriComponentsBuilder builder){
        Venda venda = service.insert(dto);

        URI uri = builder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);
    }

    @PutMapping("{id}")
    public ResponseEntity<Venda> update(@PathVariable Integer id, @Valid @RequestBody UpdateVendaDTO dto){
        Venda venda = service.update(id, dto);
        return ResponseEntity.ok(venda);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> listaVendas = service.findAll();
        return ResponseEntity.ok(listaVendas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Venda> findById(@PathVariable Integer id){
        Venda venda = service.findById(id);
        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
