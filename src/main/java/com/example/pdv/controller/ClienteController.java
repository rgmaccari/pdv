package com.example.pdv.controller;

import com.example.pdv.domain.Cliente;
import com.example.pdv.dto.ClienteDTO;
import com.example.pdv.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody @Valid ClienteDTO dto, UriComponentsBuilder builder){
        Cliente cliente = new Cliente(dto);
        cliente = service.insert(cliente);

        URI uri = builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> listaClientes = service.findAll();
        return ResponseEntity.ok(listaClientes);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody @Valid ClienteDTO dto){
        Cliente cliente = new Cliente(id, dto);
        cliente = service.update(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
