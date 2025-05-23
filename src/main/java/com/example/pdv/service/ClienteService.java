package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.repository.ClienteRepository;
import com.example.pdv.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Integer id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public void delete(Integer id){
        clienteRepository.deleteById(id);
    }
}
