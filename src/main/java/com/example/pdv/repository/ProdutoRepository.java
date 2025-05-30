package com.example.pdv.repository;

import com.example.pdv.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    public List<Produto> findAllByDescricaoContainingIgnoreCaseOrderByDescricao(String descricao);
}
