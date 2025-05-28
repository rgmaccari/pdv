package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.Produto;
import com.example.pdv.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto insert(Produto produto){
        return repository.save(produto);
    }

    public Produto update(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Optional<Produto> findById(Integer id){
        Optional<Produto> produto = repository.findById(id);

        if(produto.isPresent()){
            return produto;
        }else{
            return null;
        }
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
