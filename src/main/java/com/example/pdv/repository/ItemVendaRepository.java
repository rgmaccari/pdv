package com.example.pdv.repository;

import com.example.pdv.domain.ItemVenda;
import com.example.pdv.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
    public boolean existsByIdAndVenda(Integer id, Venda venda);
}
