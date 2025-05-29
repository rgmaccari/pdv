package com.example.pdv.service;

import com.example.pdv.domain.Cliente;
import com.example.pdv.domain.Produto;
import com.example.pdv.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
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
        if(!repository.existsById(produto.getId()))
            throw new EntityNotFoundException("Produto id " + produto.getId() + " não encontrado.");

        return repository.save(produto);
    }

    public List<Produto> findAll(){
        List<Produto> produtos = repository.findAll();

        if(produtos.isEmpty())
            throw new EntityNotFoundException("Nenhum produto encontrado.");

        return produtos;
    }

    public Produto findById(Integer id){
        Optional<Produto> produto = repository.findById(id);

        if(produto.isEmpty())
            throw new EntityNotFoundException("Produto id " + id + " não encontrado.");

        return produto.get(); //Extrai o produto do Optional.
    }

    public void delete(Integer id){
        if(!repository.existsById(id))
            throw new EntityNotFoundException("Produto id " + id + " não encontrado.");

        repository.deleteById(id);
    }
}
