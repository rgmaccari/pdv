package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.repository.ClienteRepository;
import com.example.pdv.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
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
        if(!repository.existsById(cliente.getId()))
            throw new EntityNotFoundException();

        return repository.save(cliente);
    }

    public Cliente findById(Integer id){
        Optional<Cliente> cliente = repository.findById(id);

        if(cliente.isEmpty())
            throw new EntityNotFoundException();

        return cliente.get(); //.get extrai o cliente de dentro do Optional<>
    }

    public List<Cliente> findAll(){
        List<Cliente> clientes = repository.findAll();

        if(clientes.isEmpty())
            throw new EntityNotFoundException();

        return clientes;
    }

    public void delete(Integer id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException();

        repository.deleteById(id);
    }
}
