package com.example.pdv.service;

import com.example.pdv.domain.Venda;
import com.example.pdv.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repository;

    public Venda insert(Venda venda){
        return repository.save(venda);
    }

    public Venda update(Venda venda){
        return repository.save(venda);
    }

    public List<Venda> findAll(){
        return repository.findAll();
    }

    public Optional<Venda> findById(Integer id){
        return repository.findById(id);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
