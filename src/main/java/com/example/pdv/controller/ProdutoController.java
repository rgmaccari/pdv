package com.example.pdv.controller;

import com.example.pdv.domain.Produto;
import com.example.pdv.dto.ProdutoDTO;
import com.example.pdv.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody @Valid ProdutoDTO dto, UriComponentsBuilder builder){
        Produto produto = new Produto(dto);
        produto = service.insert(produto);

        URI uri = builder.path("/cliente/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody @Valid ProdutoDTO dto){
        Produto produto = new Produto(id, dto);
        service.update(produto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> listaProdutos = service.findAll();
        return ResponseEntity.ok(listaProdutos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
