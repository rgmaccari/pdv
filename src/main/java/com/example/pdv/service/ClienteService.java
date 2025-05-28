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
    private ClienteRepository repository;

    public Cliente insert(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> findById(Integer id){
        Optional<Cliente> cliente = repository.findById(id);

        if(cliente.isPresent()){
            return cliente;
        }else{
            return null;
        }
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
